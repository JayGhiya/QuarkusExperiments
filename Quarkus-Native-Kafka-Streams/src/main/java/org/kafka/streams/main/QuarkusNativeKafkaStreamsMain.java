package org.kafka.streams.main;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

@QuarkusMain
public class QuarkusNativeKafkaStreamsMain {

    private static final Logger LOG = Logger.getLogger(QuarkusNativeKafkaStreamsMain.class);


    public static void main(String ... args) {
        LOG.info("Running main method");
        Quarkus.run(args);
    }

}
