package org.quarkus.trireme.module.job.validate;

import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.quarkus.trireme.module.models.JarInformation;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ReactiveHl7JarCheck {

    private static final Logger LOG = Logger.getLogger(ReactiveHl7JarCheck.class);

    @ConfigProperty(name = "flink.jar.hl7.name")
    private String hl7JarName;

    public Uni<Boolean> checkHl7Jar(Uni<JarInformation> flinkJarsInformationUni)
    {
        return flinkJarsInformationUni.onItem()
                .transform(jarInformation ->{
                      //  LOG.infof("inside check jar %s",jarInformation.getFiles().get(0).getName());
                        return jarInformation.getFiles().get(0).getName();
    })
                .onItem()
                .transform(flinkJarFileName ->
                {

    LOG.infof("Flink Jar Name is %s",flinkJarFileName);
                    LOG.infof("Submiited Jar Name is %s",hl7JarName);
                    return hl7JarName.equals(flinkJarFileName);
                })
                .onFailure().recoverWithItem(()->
                        {       LOG.info("Jar could not be found");
                                return Boolean.FALSE;
                        } );
}
    }


