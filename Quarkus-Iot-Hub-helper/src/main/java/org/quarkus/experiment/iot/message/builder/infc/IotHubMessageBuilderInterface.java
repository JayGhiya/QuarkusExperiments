package org.quarkus.experiment.iot.message.builder.infc;


import com.microsoft.azure.sdk.iot.service.Message;

import java.io.UnsupportedEncodingException;


public interface IotHubMessageBuilderInterface {

    Message generateIotHubMessage(String messageId, String payload) throws UnsupportedEncodingException;
}
