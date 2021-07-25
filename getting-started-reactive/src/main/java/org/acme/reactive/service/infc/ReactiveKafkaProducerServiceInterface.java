package org.acme.reactive.service.infc;

import org.acme.model.SamplePojo;

import java.util.concurrent.CompletionStage;

public interface ReactiveKafkaProducerServiceInterface {

    public CompletionStage<Void> postMessageToKafka(SamplePojo message);

}
