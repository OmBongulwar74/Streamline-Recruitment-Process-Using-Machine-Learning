
import java.util.*;
import java.io.*;
import java.sql.*;
import java.rmi.*;

public class MainController {

    private StringTokenizer st;
    private String tokens;
    private Boolean adminflag = true;
    Connection con;
    Statement stmt;
    ResultSet rs;
    ReadMessages read = null;
    SendMessage send = null;
    public static String mobile = null;
    private String command = null;
    private String message = null;
    public static String Dmobile = null;
    private String val1 = null;
    private String val2 = null;
    private String host = null;
    int no_of_tokens;

    public MainController()
    {
        send = new SendMessage();
        read = new ReadMessages();


        Timer timer = new Timer();
        try {
            timer.scheduleAtFixedRate(new TimerTask()
             {


                public void run() {
					try
							                    {
							                        executeCommand();
							                    } catch (Exception ex) {
							                        ex.printStackTrace();
					                    }

                }
            }, 3 * 1000, 10*1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void executeCommand() throws Exception
    {
       try
            {
                Hashtable hash = read.doIt();
                mobile = (String) hash.get("mobno");
                message = (String) hash.get("message");
            }
            catch (Exception e)
            {
                System.out.println("Exception is" + e);
            }

            System.out.println(" Mobile Number Is :" + mobile);
            System.out.println(" Message Is :" + message);

            //String qur="select * from admindetail where MobileNo="+mobile+";";
            //rs=stmt.executeQuery(qur);

            //if(rs.next())//
            if(mobile != null)
            {
                if (mobile.equalsIgnoreCase("+918796946934"))
                {
                    System.out.println("Cell Number Valid*****************************");
                } else
                {
                    send.sentSMS(mobile, "You are not authorized person to use system.");
                    System.out.println("Cell Number InValid*****************************");
                }
                message.trim();
                st = new StringTokenizer(message, "@");
                no_of_tokens = st.countTokens();
                String host = null;
                String command = null;
                String arg1 = null;
                String arg2 = null;
                if (st.hasMoreElements()) {
                    host = (String) st.nextElement();
                }
                if (st.hasMoreElements()) {
                    command = (String) st.nextElement();
                }
                if (st.hasMoreElements()) {
                    arg1 = (String) st.nextElement();
                }
                if (st.hasMoreElements()) {
                    arg2 = (String) st.nextElement();
                }

                String serverURL = "rmi://" + host + "/LANServer";
                LANServerIntf lanserverintf = (LANServerIntf) Naming.lookup(serverURL);

                switch (no_of_tokens) {
                    case 2: // SHUTDOWN(host@s/S) RESTART(host@r/R) LOGOFF(host@l/L)
                        if (command.equalsIgnoreCase("S")) {
                            String reply = lanserverintf.doShutdown();
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("L")) {
                            String reply = lanserverintf.doLogoff();
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("R")) {
                            String reply = lanserverintf.doRestart();
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        break;
                    case 3: //NEWFILE  host@NF@d://filename.txt) DELETEFILE host@DF@d://filename.txt)
                        if (command.equalsIgnoreCase("CP")) {
                            String reply = lanserverintf.doChangePass(arg1);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("kp")) {
                            String reply = lanserverintf.doKill(arg1);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("nf")) {
                            String reply = lanserverintf.doFileCreate(arg1);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("fd")) {
                            String reply = lanserverintf.doFileDel(arg1);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        break;
                    case 4: // RENAMEFILE,WRITEFILE
                        if (command.equalsIgnoreCase("fw")) {
                            String reply = lanserverintf.doFileWrite(arg1, arg2);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        if (command.equalsIgnoreCase("fr")) {
                            String reply = lanserverintf.doFileRename(arg1, arg2);
                            System.out.println("Reply from remote side: " + reply);
                            send.sentSMS(mobile,reply);
                        }
                        break;
                }
            }
    }

    public static void main(String args[]) throws Exception {

        MainController m = new MainController();
    }
}