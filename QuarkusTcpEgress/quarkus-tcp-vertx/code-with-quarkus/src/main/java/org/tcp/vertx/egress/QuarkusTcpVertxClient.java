package org.tcp.vertx.egress;


import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.UniOnItem;
import io.smallrye.mutiny.infrastructure.Infrastructure;


import io.vertx.core.net.NetClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.buffer.Buffer;
import io.vertx.mutiny.core.net.NetClient;
import io.vertx.mutiny.core.net.NetSocket;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;


@ApplicationScoped
public class QuarkusTcpVertxClient {

    private final Vertx vertx;

    private NetClient vertxNetClient;

    private Uni<NetSocket> netSocket;

    @Inject
    private QuarkusTcpVertxDataHandler quarkusTcpVertxDataHandler;

    public static final Logger LOG = Logger.getLogger(QuarkusTcpVertxClient.class);

    @ConfigProperty(name="demo.application.poc.quarkus.tcp.connection.timeout")
    protected int quarkusVertxTcpConnectionTimeout;

    @ConfigProperty(name="vertx.poc.quarkus.tcp.reconnection.attempts",defaultValue = "5")
    protected int quarkusVertxReconnectionAttempts;

    @ConfigProperty(name="vertx.poc.quarkus.tcp.reconnection.interval",defaultValue = "500")
    protected long quarkusVertxReconnectionInterval;

    @ConfigProperty(name="vertx.poc.quarkus.tcp.connection.port",defaultValue = "1234")
    protected int quarkusVertxServerPort;

    @ConfigProperty(name="vertx.poc.quarkus.tcp.connection.host",defaultValue = "localhost")
    protected String quarkusVertxServerHost;


    @Inject
    public QuarkusTcpVertxClient(Vertx vertx)
    {
        this.vertx = vertx;

    }

    @PostConstruct
    public void startVertxClient()
    {
        LOG.infof("quarkus connection timeout is %d",quarkusVertxTcpConnectionTimeout);
        NetClientOptions options = getNetClientOptions();
        this.vertxNetClient = this.vertx.createNetClient(options);
        this.netSocket = makeConnectionToTcpServer();


    }


    protected NetClientOptions getNetClientOptions()
    {
        NetClientOptions netClientOptions = new NetClientOptions();
        netClientOptions.setConnectTimeout(quarkusVertxTcpConnectionTimeout);
        netClientOptions.setReconnectAttempts(quarkusVertxReconnectionAttempts);
        netClientOptions.setReconnectInterval(quarkusVertxReconnectionInterval);
        netClientOptions.setReceiveBufferSize(27);
        return netClientOptions;
    }

    protected Uni<NetSocket> makeConnectionToTcpServer()
    {
          return this.vertxNetClient.connect(quarkusVertxServerPort,quarkusVertxServerHost);

    }



    @ConsumeEvent("mockmessages")
    public void greeting(String msg)
    {
                //Now Writing Data
                //async call so using call
                this.netSocket
                        .emitOn(Infrastructure.getDefaultWorkerPool())
                        .invoke(netSocket1 -> netSocket1.handler(this.quarkusTcpVertxDataHandler))
                        .call(netSocket ->netSocket.write(msg))
                .onFailure()
                .retry()
                .withBackOff(Duration.ofMillis(100),Duration.ofSeconds(1))
                .atMost(3)
                .subscribe()
                .with(netSocket -> LOG.info("Successfully sent the message"))
                ;
    }






}
