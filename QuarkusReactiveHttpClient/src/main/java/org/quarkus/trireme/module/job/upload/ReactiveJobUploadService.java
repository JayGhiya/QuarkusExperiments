package org.quarkus.trireme.module.job.upload;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.WebClient;
import io.vertx.mutiny.ext.web.multipart.MultipartForm;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.quarkus.trireme.module.models.JarUploadResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReactiveJobUploadService implements ReactiveJobUploadInterface {

    private final Vertx vertx;

    private final WebClient client;

    private static final Logger LOG = Logger.getLogger(ReactiveJobUploadService.class);

    @ConfigProperty(name = "flink.jar.hl7.name")
    protected String hl7JarName;

    @ConfigProperty(name = "flink.port")
    protected int flinkPort;

    @ConfigProperty(name = "flink.host.ip")
    protected String flinkHostIp;

    protected String jarId;

    @Inject
    public ReactiveJobUploadService(Vertx vertx) {
        this.vertx = vertx;
        this.client = WebClient.create(vertx);
    }

    @Override
    public Uni<JarUploadResponse> uploadIfJobDoesNotExist() {


        MultipartForm multipartForm = formMultiPart();
        Uni<JarUploadResponse> uploadResponseUni = uploadJar(multipartForm);
        return uploadResponseUni;


    }


    protected MultipartForm formMultiPart() {
        MultipartForm multipartForm = MultipartForm.create()
                .binaryFileUpload(
                        "jarfile",
                        hl7JarName,
                        System.getProperty("user.dir") + "/" + hl7JarName,
                        "multipart/form-data");
        LOG.info("Prepared the multipart");
        return multipartForm;
    }

    protected Uni<JarUploadResponse> uploadJar(MultipartForm multipartForm) {
        return client.post(flinkPort, flinkHostIp, "/jars/upload")
                .putHeader("Content-Type", "multipart/form-data")
                .sendMultipartForm(multipartForm)
                .onItem()
                .transform(
                        bufferHttpResponse -> bufferHttpResponse.bodyAsJson(JarUploadResponse.class)
                )
                .emitOn(Infrastructure.getDefaultWorkerPool());
    }


}
