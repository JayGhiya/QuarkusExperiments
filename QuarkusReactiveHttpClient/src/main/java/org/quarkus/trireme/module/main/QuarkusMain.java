package org.quarkus.trireme.module.main;

import io.quarkus.runtime.Quarkus;
import org.jboss.logging.Logger;

@io.quarkus.runtime.annotations.QuarkusMain
public class QuarkusMain {

    private static final Logger LOG = Logger.getLogger(QuarkusMain.class);

    public static void main(String ... args)
    {
        LOG.info("Running main method");
        LOG.info(System.getProperty("user.dir"));
        Quarkus.run(args);
    }

}
