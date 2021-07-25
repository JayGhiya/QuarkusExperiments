package org.acme.getting.started;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import org.acme.model.SamplePojo;
import org.acme.reactive.service.infc.ReactiveKafkaProducerServiceInterface;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.function.Function;

@Path("/hello")
public class ReactiveHttpResourceHandler {

    @Inject
    ReactiveKafkaProducerServiceInterface reactiveKafkaProducerServiceInterface;

    @POST
    @Timeout(value = 4000)
    @NonBlocking
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> handlePostRequest(SamplePojo message)
    {
       return Uni.createFrom().completionStage(reactiveKafkaProducerServiceInterface.postMessageToKafka(message))
               .map(element -> Response.accepted().build())
                .onFailure().recoverWithItem(Response.serverError().build());

    }
}