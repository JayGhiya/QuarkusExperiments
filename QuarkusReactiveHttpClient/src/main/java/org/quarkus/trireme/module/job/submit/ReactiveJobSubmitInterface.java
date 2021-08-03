package org.quarkus.trireme.module.job.submit;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quarkus.trireme.module.models.JarSubmitResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RegisterRestClient(configKey="flink-api")
@Path("/jars")
public interface ReactiveJobSubmitInterface {


    @POST
    @Path("{jarName}/run")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<JarSubmitResponse> submitJob(@PathParam("jarName") String jarName, @QueryParam("entry-class") String entryClass
    , @QueryParam("parallelism") int parallelism);

}
