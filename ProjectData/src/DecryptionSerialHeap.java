import java.io.*;

public class DecryptionSerialHeap
{
	public static void main(String ar[])
	{
		try
		{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String sname,dname,pass;
			long avimem;

			System.out.println("Enter the Encrypted file");
   	        sname = in.readLine();

			System.out.println("Enter the Destination file");
			dname = in.readLine();

			System.out.println("\nEnter the password");
			pass=in.readLine();
/*
			Runtime rt = Runtime.getRuntime();
			avimem=rt.freeMemory();       //return memory in byte
			avimem=(avimem/1000)-709;  // 23 to 24 KB requird for os  & following cmd tak size in  MB so /1000
*/
			String command="java -Xms64m -Xmx736m DecryptionSerial "+sname+" "+dname+" "+pass;

			//String command="java -Xms64m -Xmx"+avimem+"m DecryptionSerial "+sname+" "+dname+" "+pass;

			//String command="java -Xms64m -Xmx1610m DecryptionSerial "+sname+" "+dname+" "+pass+" "+conPass;

			//System.out.println("\nAvailable Heap Memory:= "+avimem);

			String s=null;
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while ((s = stdInput.readLine()) != null)
			  {
				  System.out.println(s);
			  }

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
