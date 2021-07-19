package org.quarkus.experiment.iot.kafka;

import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.kafka.IncomingKafkaRecordMetadata;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;
import org.quarkus.experiment.iot.client.impl.QuarkusServiceClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class QuarkusKafkaReactiveConsumer {

    @Inject
    QuarkusServiceClient quarkusServiceClient;

    private static final Logger LOG = Logger.getLogger(QuarkusKafkaReactiveConsumer.class);

    private final MeterRegistry meterRegistry;

    Timer timer;

    Counter egressCounter;

    Counter ingressCounter;


    public QuarkusKafkaReactiveConsumer(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void initMetrics()
    {
        this.timer = this.meterRegistry.timer("message.processing.latency");
        this.egressCounter = this.meterRegistry.counter("messages.sent.count.to.iotHub");
        this.ingressCounter= this.meterRegistry.counter("messages.from.kafka");
    }

    public CompletionStage<Void> fallbackForIotHubService(Message<String> message)
    {
       LOG.info("Fallback called.No point in retrying now.Acking the message to avoid out of memory. Please check remote iot hub service");
       return message.ack();
    }


    @Incoming("incoming_kafka_topic_test")
    @Retry(maxRetries = 5, delay = 1000)
    @Blocking
    @Fallback(fallbackMethod = "fallbackForIotHubService")
    @Acknowledgment(Acknowledgment.Strategy.MANUAL)
    public CompletionStage<Void> process(Message<String> message) {

        return timer.record(() ->
        {
            this.ingressCounter.increment();

            IncomingKafkaRecordMetadata<String,String> incomingKafkaRecordMetadata =
                    message.getMetadata(IncomingKafkaRecordMetadata.class).orElseGet(null);
            if(incomingKafkaRecordMetadata!=null)
            {
                ConsumerRecord<String,String> consumerRecord = incomingKafkaRecordMetadata.getRecord();


                try {
                    quarkusServiceClient.sendMessageToIotHub(consumerRecord.key(),consumerRecord.value());
                } catch (IOException e) {
                    e.printStackTrace();
                    return message.nack(e);
                } catch (IotHubException e) {
                    e.printStackTrace();
                    return message.nack(e);
                }

            }

            return message.ack();
        });


    }
}
