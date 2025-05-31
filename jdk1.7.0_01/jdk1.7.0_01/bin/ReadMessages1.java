// ReadMessages.java - Sample application.
//
// This application shows you the basic procedure needed for reading
// SMS messages from your GSM modem, in synchronous mode.
//
// Operation description:
// The application setup the necessary objects and connects to the phone.
// As a first step, it reads all messages found in the phone.
// Then, it goes to sleep, allowing the asynchronous callback handlers to
// be called. Furthermore, for callback demonstration purposes, it responds
// to each received message with a "Got It!" reply.
//
// Tasks:
// 1) Setup Service object.
// 2) Setup one or more Gateway objects.
// 3) Attach Gateway objects to Service object.
// 4) Setup callback notifications.
// 5) Run

//package lanAdmin;
import java.util.*;
import org.smslib.*;
import org.smslib.modem.*;
import java.io.*;
import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.MessageTypes;
import java.util.Timer;

public class ReadMessages1 {

    private Service srv;
    public String message = "";
    public String mobno = "";

    public Hashtable doIt() throws Exception {
        System.out.println("U r in doIt method body of class ReadMessages ");
        List msgList;
        Hashtable info = new Hashtable();
        // Create the notification callback method for Inbound & Status Report
        // messages.
        InboundNotification inboundNotification = new InboundNotification();
        // Create the notification callback method for incoming voice calls.
        CallNotification callNotification = new CallNotification();
        try {
            // Create new Service object - the parent of all and the main interface
            // to you.
            srv = new Service();
            // Create the Gateway representing the serial GSM modem.
            System.out.println("service startd ....");
            SerialModemGateway gateway = new SerialModemGateway("modem.com7", "COM7", 57600, "Huwai", "E909", srv);
            // Do we want the Gateway to be used for Inbound messages? If not,
            // SMSLib will never read messages from this Gateway.
            gateway.setInbound(true);
            // Do we want the Gateway to be used for Outbound messages? If not,
            // SMSLib will never send messages from this Gateway.
            gateway.setOutbound(true);
            gateway.setSimPin("0000");
            // Set up the notification methods.
            gateway.setInboundNotification(inboundNotification);
            gateway.setCallNotification(callNotification);
            // Add the Gateway to the Service object.
            srv.addGateway(gateway);
            System.out.println("getway added ....");

            srv.startService();
            System.out.println();
            System.out.println("Modem Information:");
            System.out.println("  Manufacturer: " + gateway.getManufacturer());
            System.out.println("  Model: " + gateway.getModel());
            System.out.println("  Serial No: " + gateway.getSerialNo());
            System.out.println("  SIM IMSI: " + gateway.getImsi());
            System.out.println("  Signal Level: " + gateway.getSignalLevel() + "%");
            System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
            System.out.println();

            msgList = new ArrayList();
            System.out.println("msgList:" + msgList);

            srv.readMessages(msgList, MessageClasses.UNREAD);
            System.out.println("msgList after srv.readMessages(msgList, MessageClasses.UNREAD)=>" + msgList);
            System.out.println("fffffff");
            System.out.println("msgList.size()=>" + msgList.size());
            for (int i = 0; i < msgList.size(); i++)
            {
                InboundMessage newMessage = (InboundMessage) msgList.get(i);
                String msg = newMessage.getText();

                if(msg==null) continue;

                System.out.println("String msg = msgList.get(i).toString()=>" + msg);
                System.out.println("msg.length()=>" + msg.length());

                //TODO: Move to constants
                if(newMessage.getText().contains("@") /*&& !newMessage.getPduUserData().equalsIgnoreCase("READ")*/)
                {
                    mobno = newMessage.getOriginator();
                    message = msg;

                    info.put(mobno, "mobno");
                    info.put(message, "message");
                    info.put("mobno", mobno);
                    info.put("message", message);
                    //newMessage.setPduUserData("READ");
                    srv.deleteMessage(newMessage);
                    System.out.println("Message : "+message+" has been read");
                }
            }
            System.out.println("Now Sleeping - Hit <enter> to terminate.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            srv.stopService();
        }
        System.out.println("****************************INFO=" + info);
        return info;  //returns Hashtable object
    }

    public class InboundNotification implements IInboundMessageNotification {

        public void process(String gatewayId, MessageTypes msgType, String memLoc, int memIndex) {
            List msgList;
            if (msgType == MessageTypes.INBOUND) {
                System.out.println(">>> New Inbound message detected from Gateway: " + gatewayId + " : " + memLoc + " @ " + memIndex);
                try {
                    // Read...
                    msgList = new ArrayList();
                    srv.readMessages(msgList, MessageClasses.UNREAD, gatewayId);
                    for (int i = 0; i < msgList.size(); i++)
                    {
                        System.out.println(msgList.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("Oops, some bad happened...");
                    e.printStackTrace();
                }
            } else if (msgType == MessageTypes.STATUSREPORT) {
                System.out.println(">>> New Status Report message detected from Gateway: " + gatewayId + " : " + memLoc + " @ " + memIndex);
            }
        }
    }

    public class CallNotification implements ICallNotification {

        public void process(String gatewayId, String callerId) {
            System.out.println(">>> New call detected from Gateway: " + gatewayId + " : " + callerId);
        }
    }

    public static void main(String args[])
    {
        final ReadMessages app = new ReadMessages();
        Timer timer = new Timer();

        try {
            timer.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    try {
                        app.doIt();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }, 1 * 1000, 1*5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
