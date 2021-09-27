package org.quarkus.trireme.module.main;



import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;


import org.quarkus.trireme.module.job.upload.ReactiveJobUploadInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;


@ApplicationScoped
@Startup
public class QuarkusArch {


    @Inject
    protected ReactiveJobUploadInterface reactiveJobUploadInterface;



    private static final Logger LOG = Logger.getLogger(QuarkusArch.class);


    void startup(@Observes StartupEvent event) throws IOException {



             reactiveJobUploadInterface.uploadIfJobDoesNotExist();

        }

}



