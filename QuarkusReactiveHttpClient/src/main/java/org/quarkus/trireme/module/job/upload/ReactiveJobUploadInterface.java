package org.quarkus.trireme.module.job.upload;


import io.smallrye.mutiny.Uni;
import org.quarkus.trireme.module.models.JarUploadResponse;

public interface ReactiveJobUploadInterface {

    public Uni<JarUploadResponse> uploadIfJobDoesNotExist();

}
