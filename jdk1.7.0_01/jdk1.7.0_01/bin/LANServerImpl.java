
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class LANServerImpl extends UnicastRemoteObject implements LANServerIntf {

    public LANServerImpl() throws RemoteException {
        // constructor
    }

    public String doOpenCalc() throws RemoteException {

        try {

            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("calc");

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }

        return "Opening calculator...";
    }

    //////////////////////// Shutdown
    public String doShutdown() throws RemoteException {
        try {
            System.out.println("ooooooooooooooooooooooooo");
            Runtime.getRuntime().exec("shutdown -s -t 20");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "preparing to shutdown ....";
    }
    //////////////////////// LOGOFF

    public String doLogoff() throws RemoteException {
        try {
            System.out.println("ooooooooooooooooooooooooo");
            Runtime.getRuntime().exec("shutdown -l -t 20");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "preparing to logoff ....";
    }
    //////////////////////// RESTRAT

    public String doRestart() throws RemoteException {
        try {
            System.out.println("ooooooooooooooooooooooooo");
            Runtime.getRuntime().exec("shutdown -r -t 20");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "preparing to restart ....";
    }
    //////////////////////// CHANGEPASS

    public String doChangePass(String pass) throws RemoteException {
        try {
            Runtime.getRuntime().exec("C://windows//system32//net user Administrator " + pass);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "password changed to...." + pass;
    }

    public String doKill(String pro) throws RemoteException {
        try {
            // Runtime.getRuntime().exec("process -k "+pro);
            Runtime.getRuntime().exec("taskkill /IM  " + pro);


        } catch (Exception e) {
            System.out.println(e);
        }
        return "process " + pro + " killed sucessfully";
    }

    public String doFileCreate(String fnm) throws RemoteException {
        File f = new File(fnm);
        if (f.exists()) {
            return "file" + fnm + "already exists...!";
        } else {
            try {
                f.createNewFile();
            } catch (Exception e) {
            }
            return "file created successfully.....!";

        }


    }

    public String doFileDel(String fname) throws RemoteException {

        System.out.println("In File Delete......\t");
        File f = new File(fname);
        if (f.exists()) {
            boolean bflag = f.delete();
            System.out.println("bflag=>" + bflag);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            return "file deleted successfully" + fname;
        } else {
            System.out.println("File does not exit");
            return "file does not exist" + fname;
        }

    }

    public String doFileWrite(String file, String data) throws RemoteException {
        File f = new File(file);
        if (f.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
                PrintStream ps = new PrintStream(fos);
                ps.println(data);
            } catch (Exception e) {
            }
            return "Successfully written in file " + file;
        } else {
            return "The file you want to write is not exist ie :" + file;
        }
    }

    public String doFileRename(String f1, String f2) throws RemoteException {

        String source = f1;
        String desc = f2;
        System.out.println("source ==>" + source + "\t Desc ==>" + desc);
        File ff1 = new File(source);
        File ff2 = new File(desc);
        if (ff1.exists()) {
            System.out.println("Rename File ::::::" + ff1.renameTo(ff2));
            return "file renamed successfully" + desc;
        } else {
            return "file does not exist" + source;
        }
    }
}