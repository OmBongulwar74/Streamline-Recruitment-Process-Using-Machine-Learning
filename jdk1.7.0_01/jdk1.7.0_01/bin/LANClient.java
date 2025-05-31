
import java.rmi.*;

public class LANClient {

    public static void main(String args[]) {
        try {

            String serverURL = "rmi://" + "localhost" + "/LANServer";

            LANServerIntf lanserverintf = (LANServerIntf) Naming.lookup(serverURL);


            String reply = lanserverintf.doOpenCalc();

            System.out.println("Reply from remote side: " + reply);

        } catch (Exception e) {
            System.out.println("Exception :  " + e);
        }
    }
}