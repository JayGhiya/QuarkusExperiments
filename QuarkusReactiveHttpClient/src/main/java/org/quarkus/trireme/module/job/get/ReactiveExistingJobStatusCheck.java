package org.quarkus.trireme.module.job.get;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quarkus.trireme.module.models.JarInformation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey="flink-api")
@Path("/jars")
public interface ReactiveExistingJobStatusCheck {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<JarInformation> getJarsInformation();
}

