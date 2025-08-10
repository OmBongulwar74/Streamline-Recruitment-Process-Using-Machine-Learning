package controller;
import java.io.*;
public class DeParParHeap
{
	public static void main(String ar[])
	{
		try
		{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String sname,dname,pass;
			long avimem;

			System.out.println("Enter the source file");
   	        sname = in.readLine();

			System.out.println("Enter the destination file");
			dname = in.readLine();

			System.out.println("\nEnter the password");
			pass=in.readLine();

			String command="java -Xms64m -Xmx736m DeParPar "+sname+" "+dname+" "+pass;

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
