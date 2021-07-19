package org.quarkus.experiment.iot.configuration;


import com.microsoft.azure.sdk.iot.service.IotHubServiceClientProtocol;
import com.microsoft.azure.sdk.iot.service.ServiceClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.net.URISyntaxException;

public class IotHubConfiguration {


    @ConfigProperty(name="iothub.device.connection.string")
    String connectionString;


    private static final Logger LOG = Logger.getLogger(IotHubConfiguration.class);

    @Produces
    public ServiceClient getIot() throws URISyntaxException, IOException {
        LOG.info("Inside Service Client bean");
        if(connectionString==null) {
            LOG.info("Connection String is null");
            throw new RuntimeException("IOT CONNECTION STRING IS NULL");
        }

        ServiceClient serviceClient = new ServiceClient(connectionString, IotHubServiceClientProtocol.AMQPS);
        serviceClient.open();
        LOG.info("opened Service CLient Successfully");

        return serviceClient;
    }



}


