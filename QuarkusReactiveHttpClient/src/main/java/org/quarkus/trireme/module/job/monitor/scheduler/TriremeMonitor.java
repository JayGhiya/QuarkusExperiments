package org.quarkus.trireme.module.job.monitor.scheduler;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.quarkus.trireme.module.job.monitor.job.metrics.GetJobMetrics;
import org.quarkus.trireme.module.job.monitor.job.metrics.GetJobOverviewMetrics;
import org.quarkus.trireme.module.job.submit.ReactiveJobSubmit;
import org.quarkus.trireme.module.job.upload.ReactiveJobUploadService;
import org.quarkus.trireme.module.models.JobMetric;
import org.quarkus.trireme.module.models.JobOverview;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class TriremeMonitor {

    @Inject
    protected ReactiveJobSubmit reactiveJobSubmit;

    @RestClient
    protected GetJobMetrics getJobMetrics;

    @RestClient
    protected GetJobOverviewMetrics getJobOverviewMetrics;

    @ConfigProperty(name="flink.job.metrics")
    protected String metricList;

    private static final Logger LOG = Logger.getLogger(TriremeMonitor.class);

    @Scheduled( every = "10s", delay = 30, delayUnit = TimeUnit.SECONDS)
    public void monitorTrireme()
    {

        List<JobMetric> jobMetrics = getJobMetrics.getJobMetrics(reactiveJobSubmit.getJobId(),metricList);

        JobOverview jobOverview = getJobOverviewMetrics.getMetrics(reactiveJobSubmit.getJobId());

        LOG.infof("current state of job is %s",jobOverview.state);

        for(JobMetric jobMetric: jobMetrics)
        {
            LOG.infof("jobmetric name is %s",jobMetric.getId());
            LOG.infof("jobmetric max is %d",jobMetric.getSum());
        }

    }

}
