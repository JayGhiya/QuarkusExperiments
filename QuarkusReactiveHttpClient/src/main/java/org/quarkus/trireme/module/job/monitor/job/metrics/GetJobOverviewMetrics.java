package org.quarkus.trireme.module.job.monitor.job.metrics;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quarkus.trireme.module.models.JobOverview;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "flink-api")
@Path("jobs")
public interface GetJobOverviewMetrics {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{jobsId}")
    public JobOverview getMetrics(@PathParam("jobsId") String jobId);
}
