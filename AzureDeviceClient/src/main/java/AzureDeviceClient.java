import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.microsoft.azure.sdk.iot.device.*;
import com.microsoft.azure.sdk.iot.service.IotHubServiceClientProtocol;
import com.microsoft.azure.sdk.iot.service.ServiceClient;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;

import java.io.IOException;
import java.net.URISyntaxException;

class AppMessageCallBack implements MessageCallback{

    @Override
    public IotHubMessageResult execute(Message message, Object o) {
        System.out.println("receiving messages");
        return IotHubMessageResult.COMPLETE;
    }
}

public class AzureDeviceClient {

    public static void main(String args[]) throws URISyntaxException, IOException, IotHubException {

        DeviceClient deviceClient = new DeviceClient("HostName=bumblebee-iothub.azure-devices.net;DeviceId=iotdevice1;SharedAccessKey=NN03QUKpFtfRaTogV/TLChrfvRpaK2TO7jFaTbha1Wc=", IotHubClientProtocol.AMQPS);
        deviceClient.setMessageCallback(new AppMessageCallBack(),null);
        deviceClient.open();

    }
}
