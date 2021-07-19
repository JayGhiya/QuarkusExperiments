package org.quarkus.experiment.iot.client.impl;

import com.microsoft.azure.sdk.iot.service.Message;
import com.microsoft.azure.sdk.iot.service.ServiceClient;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.quarkus.experiment.iot.client.infc.QuarkusServiceClientInterface;
import org.quarkus.experiment.iot.message.builder.infc.IotHubMessageBuilderInterface;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;


@ApplicationScoped
public class QuarkusServiceClient implements QuarkusServiceClientInterface {

    private static final Logger LOG = Logger.getLogger(QuarkusServiceClient.class);

    @Inject
    IotHubMessageBuilderInterface iotHubMessageBuilderInterface;

    @Inject
    ServiceClient serviceClient;

    @ConfigProperty(name="iot.device.id")
    String deviceId;



    public void sendMessageToIotHub(String key,String message) throws IOException, IotHubException {

        Message iotHubMessage = iotHubMessageBuilderInterface.generateIotHubMessage(key,message);

        serviceClient.send(deviceId,iotHubMessage);
        
  }
}
