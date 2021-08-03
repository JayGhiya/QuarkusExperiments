package org.quarkus.trireme.module.job.get;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quarkus.trireme.module.models.JarInformation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReactiveExistingJobStatusService {

    @RestClient
    protected ReactiveExistingJobStatusCheck reactiveExistingJobStatusCheck;


    public Uni<JarInformation> getFlinkJarsInformation()
    {
        return reactiveExistingJobStatusCheck.getJarsInformation();

    }



}
