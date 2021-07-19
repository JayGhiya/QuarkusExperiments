package org.kafka.streams.config;

import ca.uhn.fhir.context.FhirContext;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.kafka.streams.operation.map.QuarkusKafkaStreamsMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class QuarkusKafkaStreamsTopology {

    @ConfigProperty(name="experiment.kafka.streams.input.topic")
    String inputTopic;

    @ConfigProperty(name="experiment.kafka.streams.output.topic")
    String outputTopic;

    private final MeterRegistry meterRegistry;

    Timer timer;

    Counter egressCounter;

    Counter ingressCounter;

    @Inject
    @Named("R4")
    Instance<FhirContext> fhirContextInstance;


    public QuarkusKafkaStreamsTopology(MeterRegistry meterRegistry) {

        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void initMetrics()
    {
        this.timer = this.meterRegistry.timer("message.kafka.streams.processing.latency");
        this.egressCounter = this.meterRegistry.counter("messages.kafka.streams.egress");
        this.ingressCounter= this.meterRegistry.counter("messages.kafka.streams.ingress");
    }


    @Produces
    public Topology buildTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        builder.stream(inputTopic, Consumed.with(Serdes.String(),Serdes.String()))
                .map(new QuarkusKafkaStreamsMapper(this.timer,this.ingressCounter,this.egressCounter,this.fhirContextInstance))
                .to(outputTopic, Produced.with(Serdes.String(),Serdes.String()));

        return builder.build();

    }



}