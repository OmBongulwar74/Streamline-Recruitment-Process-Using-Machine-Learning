import java.io.*;
import java.util.*;

class DecryptionSerial
{

	private long length;
	private int x,y;
	String filename,dpath,keyword,original_keyword,timepass,pass;
	public int skip_bytes,generate,save[][],number[];
	boolean flag;
	long read_length;

	public DecryptionSerial(String s,String d,String Pwd)
	{
	  try
	   {
	 	this.filename = s;
		this.dpath = d;
		this.pass=Pwd;
		DataInputStream din=new DataInputStream(new FileInputStream(filename));
		flag = din.readBoolean();

		if(flag)
		 read_length = din.readLong();
		generate = din.readInt();
		timepass = din.readUTF();

		byte[] string = timepass.getBytes();
		for(int k = 0;k < timepass.length();k++)
		{
		   string[k] = new Integer(string[k]^generate%256).byteValue();
        }
		original_keyword = new String(string);
		din.close();
		this.getFileLength();

		if(this.length==0)
			System.out.println("File is Empty");

		this.MatchKeyword();
	   }
      catch(Exception e){}
	}


	private void getFileLength()
	{
	  RandomAccessFile rFile;
   	  try
     	{
	      File f = new File(filename);
          this.skip_bytes = 1 + this.timepass.length()  + 8 + 4 + 2;
		  rFile=new RandomAccessFile(this.filename,"rw");
		  this.length=rFile.length() - this.skip_bytes;
		}
		catch(EOFException e)
		{
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	private void MatchKeyword()
	{
	   try
	   {
	   	 if(original_keyword.equals(pass))
		 {
     		 Calendar calendar = new GregorianCalendar();
			 System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
		     calendar = null;

		     System.out.println("\nPlease Wait Decryption Process working............");

			 keyword = original_keyword;
			 assignOrder();
			 x=keyword.length();
			 y=(length%x==0)?((int)length/x):((int)length/x)+1;
			 getIntoArray();
			 getIntoFile();

			 System.out.println("\nDecryption completed successfully");

			 calendar = new GregorianCalendar();
			 System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
		     calendar = null;
 		}
		else
		   System.out.println("Your password does not match with original password");
       }
		catch(Exception e){}
	}




	private void assignOrder()
		{
			int min=512,lastMin=0,order=0;
			number = new int[keyword.length()];
			try
			{
				for(int i=0;i<keyword.length();i++)
				{
					for(int j=0;j<keyword.length();j++)
					{
						if((int)keyword.charAt(j) < min && (int)keyword.charAt(j) > lastMin)
							min = (int)keyword.charAt(j);
					}
					for(int k=0;k<keyword.length();k++)
					{
						if((int)keyword.charAt(k)==min)
							number[k] = order++;
					}
					lastMin=min;
					min=512;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	    }



	private void getIntoArray()
	{
		try
		{

			InputStream fin=new FileInputStream(filename);
			save=new int[x][y];
			long l = fin.skip(skip_bytes);
			if(l != skip_bytes)
				System.out.println("Decryption may encounter a problem");
			int ch=fin.read();
			while(ch!=-1)
			{
			 for(int r=0;r<this.x;r++)
		   	 {
	  		  int temp=0;
		 	  while(number[temp]!=r || temp>=x)
				temp++;
			  for(int c=0;c<y;c++)
			   {
			  	save[temp][c]=(char)ch;
				ch=fin.read();
			   }
		     }
		   }
		  fin.close();
		}
		catch(Exception e){}
	}



	private void getIntoFile()
	{
	  try
	   {
		  long counter = 0L;
		  OutputStream dout=new FileOutputStream(dpath);
		  for(int i=0;i<y;i++)
		  {
		   for(int j=0;j<x;j++)
		   {
			 dout.write(save[j][i]);
			 counter++;

			 if(counter == read_length)
			 break;
		   }
		  }
		   dout.close();
        }
 	   catch(Exception e){}
    }



  public static void main(String a[])
  {
	String sname,dname,pass;
	try
	{
      sname=a[0];
	  dname=a[1];
	  pass=a[2];

      DecryptionSerial obj=new DecryptionSerial(sname,dname,pass);
    }
    catch(Exception e){}
  }

}
