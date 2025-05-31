//package lanAdmin;
import org.smslib.*;
import org.smslib.modem.*;
import java.util.*;

public class SendMessage {

    public void sentSMS(String moileNo, String content) throws Exception {

        System.out.println("in sending mode......!");
        Service srv;
        OutboundMessage msg;

        OutboundNotification outboundNotification = new OutboundNotification();
        System.out.println("test1");

        srv = new Service();
        SerialModemGateway gateway = new SerialModemGateway("modem.com7", "COM7", 57600, "Huwai", "E909", srv);
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        gateway.setOutboundNotification(outboundNotification);
        srv.addGateway(gateway);
        System.out.println("test2");

        srv.startService();
        System.out.println("test3");

        msg = new OutboundMessage(moileNo, content);
        srv.sendMessage(msg);
        System.out.println(msg);
        //	System.in.read();
        System.out.println("........Successful.....");
        srv.stopService();
    }

    public class OutboundNotification implements IOutboundMessageNotification {

        public void process(String gatewayId, OutboundMessage msg) {
            //	System.out.println("Outbound handler called from Gateway: " + gatewayId);
            //	System.out.println(msg);
        }
    }

    public static void main(String args[]) {
        SendMessage app = new SendMessage();
        try {
            System.out.println("in try1......!");
            //app.sentSMS("7709193069","Code Working...............");
            //app.sentSMS("8983969368","hi............:* ");
            //app.sentSMS("9850650169","Code Working...............");
            System.out.println("in try2......!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
