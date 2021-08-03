package org.quarkus.trireme.module.job.submit;

import io.smallrye.mutiny.Uni;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.quarkus.trireme.module.models.JarInformation;
import org.quarkus.trireme.module.models.JarUploadResponse;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class ReactiveJobSubmit {


    @RestClient
    protected ReactiveJobSubmitInterface reactiveJobSubmitInterface;

    @ConfigProperty(name="flink.main.class")
    protected String mainClass;

    @ConfigProperty(name="flink.program.parallelism")
    protected int parallelism;

    @Getter
    protected String jobId;

    private static final Logger LOG = Logger.getLogger(ReactiveJobSubmit.class);


    public void submitJob(JarUploadResponse jarInformation)
    {

        String[] fileNameSplit = jarInformation.getFileName().split("/");
        String jobName = fileNameSplit[fileNameSplit.length-1];
        reactiveJobSubmitInterface.submitJob(jobName,mainClass,parallelism)
        .subscribe()
        .with(jarSubmitResponse -> {
            this.jobId = jarSubmitResponse.getJobId();
            LOG.infof("JOB ID IS %s",this.jobId);});
    }



}
