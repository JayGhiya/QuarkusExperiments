package org.tcp.vertx.egress;

import io.vertx.core.Handler;


import io.vertx.mutiny.core.buffer.Buffer;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Consumer;

@ApplicationScoped
public class QuarkusTcpVertxDataHandler implements Consumer<Buffer> {

    public static final Logger LOG = Logger.getLogger(QuarkusTcpVertxDataHandler.class);



    @Override
    public void accept(Buffer buffer) {

        LOG.infof("received Object is %s",buffer.getString(0,buffer.length()));

    }


}
