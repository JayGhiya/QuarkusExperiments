package org.quarkus.experiment.iot.main.main;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

@QuarkusMain
public class NotificationIOTHubMain {

    private static final Logger LOG = Logger.getLogger(NotificationIOTHubMain.class);

    public static void main(String ... args) {
        LOG.info("Running main method");
        Quarkus.run(args);
    }

}
