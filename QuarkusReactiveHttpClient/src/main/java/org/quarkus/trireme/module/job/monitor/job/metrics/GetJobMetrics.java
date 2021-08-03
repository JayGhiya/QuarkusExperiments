package org.quarkus.trireme.module.job.monitor.job.metrics;

import io.smallrye.common.annotation.Blocking;
import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.quarkus.trireme.module.models.JobMetric;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey="flink-api")
@Path("/jobs")
public interface GetJobMetrics {


    @Path("/metrics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobMetric> getJobMetrics(@QueryParam("jobs") String jobId, @QueryParam("get") String metricsList );


}
