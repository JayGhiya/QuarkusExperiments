package org.quarkus.trireme.module.main;



import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import org.jboss.logging.Logger;
import org.quarkus.trireme.module.job.get.ReactiveExistingJobStatusService;
import org.quarkus.trireme.module.job.submit.ReactiveJobSubmit;
import org.quarkus.trireme.module.job.upload.ReactiveJobUploadInterface;
import org.quarkus.trireme.module.job.validate.ReactiveHl7JarCheck;
import org.quarkus.trireme.module.models.JarInformation;
import org.quarkus.trireme.module.models.JarUploadResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;


@ApplicationScoped
@Startup
public class QuarkusTriremeArch {


    @Inject
    protected ReactiveExistingJobStatusService reactiveExistingJobStatusService;

    @Inject
    protected ReactiveHl7JarCheck reactiveHl7JarCheck;

    @Inject
    protected ReactiveJobUploadInterface reactiveJobUploadInterface;

    @Inject
    protected ReactiveJobSubmit reactiveJobSubmitService;


    private static final Logger LOG = Logger.getLogger(QuarkusTriremeArch.class);


    void startup(@Observes StartupEvent event) throws IOException {
        LOG.info("TRIREME ARCH HAS STARTED");

        //get existing jar
        Uni<JarInformation> flinkJarsInformationUni = reactiveExistingJobStatusService.getFlinkJarsInformation();

        //verify hl7 exists or not
        Uni<Boolean> booleanUni = reactiveHl7JarCheck.checkHl7Jar(flinkJarsInformationUni).emitOn(Infrastructure.getDefaultWorkerPool());

        //if it does not exist upload and submit the jar
        if(!(booleanUni.await().atMost(Duration.ofSeconds(3)))) {
            JarUploadResponse jarUploadResponseUni = reactiveJobUploadInterface.uploadIfJobDoesNotExist()
                    .await().atMost(Duration.ofSeconds(3));
            //submit the jar
            reactiveJobSubmitService.submitJob(jarUploadResponseUni);
        }

        }





    }





