
import java.net.*;
import java.rmi.*;

public class LANServer {

    public static void main(String args[]) {
        try {
            LANServerImpl a1 = new LANServerImpl();
            Naming.rebind("LANServer", a1);
        } catch (Exception e) {
            System.out.println("Exception... " + e);
        }
    }
}