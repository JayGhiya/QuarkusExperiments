package org.quarkus.experiment.iot.message.builder.impl;

import com.microsoft.azure.sdk.iot.service.Message;
import org.quarkus.experiment.iot.message.builder.infc.IotHubMessageBuilderInterface;


import javax.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;

@ApplicationScoped
public class IotHubMessageBuilder implements IotHubMessageBuilderInterface {

    public Message generateIotHubMessage(String messageId, String payload) throws UnsupportedEncodingException {
        Message message = new Message(payload);
        message.setMessageId(messageId);
        return message;
    }

}
