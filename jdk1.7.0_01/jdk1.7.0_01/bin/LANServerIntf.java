import java.rmi.*;

public interface LANServerIntf extends Remote
{
public String doOpenCalc()throws RemoteException;
public String doShutdown()throws RemoteException;
public String doLogoff()throws RemoteException;
public String doRestart()throws RemoteException;
public String doChangePass(String pass) throws RemoteException;
public String doKill(String pro)throws RemoteException;
public String doFileCreate(String fnm)throws RemoteException;
public String doFileDel(String fname)throws RemoteException;
public String doFileWrite(String file,String data)throws RemoteException;
public String doFileRename(String f1,String f2)throws RemoteException;
}