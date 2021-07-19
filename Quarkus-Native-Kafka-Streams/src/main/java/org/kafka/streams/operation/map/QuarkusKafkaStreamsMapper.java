package org.kafka.streams.operation.map;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.hl7.fhir.r4.model.Observation;
import org.jboss.logging.Logger;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicReference;


public class QuarkusKafkaStreamsMapper implements KeyValueMapper<String,String, KeyValue<String,String>> {

    FhirContext fhirContext;

    private static final Logger LOG = Logger.getLogger(QuarkusKafkaStreamsMapper.class);

    Timer latencyRecorder;

    Counter ingressCounter;

    Counter egressCounter;



    public QuarkusKafkaStreamsMapper(Timer timer,Counter ingressCounter,Counter egressCounter,Instance<FhirContext> fhirContextInstance)
    {
        this.latencyRecorder = timer;
        this.ingressCounter = ingressCounter;
        this.egressCounter = egressCounter;
        this.fhirContext = fhirContextInstance.get();
    }

    @Override
    public KeyValue<String, String> apply(String s, String s2) {
        this.ingressCounter.increment();
        AtomicReference<String> jsonBloodPressure = new AtomicReference<>();
        IParser iParser = fhirContext.newJsonParser();
        this.latencyRecorder.record(() ->
        {
            Observation bloodPressure = (Observation)iParser.parseResource(s2);
            LOG.infof("bloodpressure is %s",bloodPressure.getStatus().getDisplay());

            jsonBloodPressure.set(iParser.encodeResourceToString(bloodPressure));
        });
        this.egressCounter.increment();
        return new KeyValue<>(s,jsonBloodPressure.get());
    }
}
