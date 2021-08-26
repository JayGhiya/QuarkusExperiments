package org.tcp.vertx.main;

import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.tcp.vertx.data.produce.DataProducerMock;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
@Startup
public class QuarkusModuleTcpEgressMain {


    @Inject
    DataProducerMock dataProducerMock;


    void startup(@Observes StartupEvent event) {

        dataProducerMock.produceMessages();

    }



}
