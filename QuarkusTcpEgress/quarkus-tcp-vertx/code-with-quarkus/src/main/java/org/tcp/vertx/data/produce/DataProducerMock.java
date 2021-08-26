package org.tcp.vertx.data.produce;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.eventbus.EventBus;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;


@ApplicationScoped
public class DataProducerMock {

    @Inject
    EventBus bus;

    private static final Logger LOG = Logger.getLogger(DataProducerMock.class);

    private static final String sampleHl7Message = "MSH|^~\\&|EPIC|^LINDAS TEST ORGANIZATION|||||VXU^V04^VXU_V04|225|P|2.5.1||||AL|PID|1||E46749^^^^MR^||DOE^JOHN^C^JR^^^L|SMITH|20140515|M|SMITH^JOHN|2106-3^WHITE^HL70005|115 MAINSTREET^^GOODTOWN^KY^42010^USA^L^010||^PRN^PH^^^270^6009800||EN^ENGLISH^HL70296||||523968712|||2186-5^NOT HISPANIC OR LATINO^HL70012||||||||N|\n" +
            "PD1|||LINDAS TEST ORGANIZATION^^SIISCLIENT818|^^^^^^^^^^^^MR|||||||02^Reminder/recall-any method^HL70215|||||A^Active^HL70441|20150202^20150202 NK1|1|DOE^MARY|MTH^MOTHER^HL70063|\n" +
            "PV1||R||||||||||||||||||V02^20150202|\n" +
            "ORC|RE||9645^SIISCLIENT001||||||20150202111146|2001^HARVEY^MARVIN^K| RXA|0|1|20150202|20150202|20^DTaP^CVX^90700^DTAP^CPT|.5|ML^mL^ISO+||00^New immunization record^NIP001|JONES^MARK|^^^SIISCLIENT818||||A7894-2|20161115|PMC^SANOFI PASTEUR^MVX||||ARXR|ID^INTRADERMAL^HL70162|LD^LEFT DELTOID^HL70163\n" +
            "OBX|1|CE|64994-7^VACCINE FUNDING PROGRAM ELIGIBILITY CATEGORY^LN|1| V02^MEDICAID^HL70064||||||F|||20150202|||VXC40^ELIGIBILITY CAPTURED AT THE IMMUNIZATION LEVEL^CDCPHINVSOBX|2|CE|30956-7^VACCINE TYPE^LN|2|88^FLU^CVX||||||F|||20150202102525 OBX|3|TS|29768-9^Date vaccine information statement published^LN|2|20120702||||||FOBX|4|TS|29769-7^Date vaccine information statement presented^LN|2|20120202||||||F\n" +
            "RXA|0|1|20141215|20141115|141^influenza, SEASONAL 36^CVX^90658^Influenza Split^CPT|999|||01^HISTORICAL INFORMATION – SOURCE UNSPECIFIED^ NIP001||||||||||||A";

    public void produceMessages()
    {

        int count = 10;

        while(count>0)
        {
            bus.send("mockmessages",sampleHl7Message);
            count--;
        }
    }

}
