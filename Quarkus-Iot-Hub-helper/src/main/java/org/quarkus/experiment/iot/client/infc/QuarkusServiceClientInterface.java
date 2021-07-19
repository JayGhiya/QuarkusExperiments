package org.quarkus.experiment.iot.client.infc;


import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;

import java.io.IOException;


public interface QuarkusServiceClientInterface {

    void sendMessageToIotHub(String key,String payload) throws IOException, IotHubException;
}
