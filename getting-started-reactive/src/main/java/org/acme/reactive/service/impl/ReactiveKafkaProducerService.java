package org.acme.reactive.service.impl;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import io.smallrye.reactive.messaging.kafka.Record;
import org.acme.model.SamplePojo;
import org.acme.reactive.service.infc.ReactiveKafkaProducerServiceInterface;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.hl7.fhir.r4.model.Observation;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ReactiveKafkaProducerService implements ReactiveKafkaProducerServiceInterface {

    @Inject
    @Channel("kafka_topic")
    Emitter<String> emitter;

    @Inject
    @Named("R4")
    Instance<FhirContext> fhirContextInstance;

    private static final Logger LOG = Logger.getLogger(ReactiveKafkaProducerService.class);

    @Override
    public CompletionStage<Void> postMessageToKafka(SamplePojo message) {

        IParser iparser = fhirContextInstance.get().newJsonParser();

        Observation bloodPressure = (Observation)iparser.parseResource(message.getData());


        iparser.encodeResourceToString(bloodPressure);

        return emitter.send(message.getData())
                .whenComplete((success, failure) -> {
                    if (failure != null) {
                        LOG.errorf("Failure is %s" , failure.getMessage());
                    } else {
                        LOG.info("Message processed successfully");
                    }
                });
    }

}
