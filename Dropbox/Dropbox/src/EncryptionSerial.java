import java.io.*;
import java.util.*;

class EncryptionSerial
{
	private long length;
	private int x,y;
	public static String keyword,filename,dpath;
	public int save[][],number[];
	static String pass,conPass;

	EncryptionSerial(){}

	public EncryptionSerial(String s, String d,String pwd,String conpwd)
	{
		try
		{
			this.filename = s;
			this.dpath = d;
			this.getFileLength();
			this.pass=pwd;
			this.conPass=conpwd;

			if(this.length==0)
			{
				System.out.println("Make sure that the file is not empty or Read Only");
				return;
			}
			MatchKeyword();
		}
		catch(OutOfMemoryError e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e+" Exception");
		}
	}


	private void getFileLength()
	{
		RandomAccessFile rFile;
		try
		{
			rFile=new RandomAccessFile(this.filename,"rw");
			this.length=rFile.length();
			Runtime rt = Runtime.getRuntime();
			if(this.length > rt.maxMemory())
			{
				System.out.println("Required amount of memory not available");
				System.exit(0);
			}
		}
		catch(EOFException e)
		{
			System.out.println("File is suspicious or has been modified\nCannot encrypt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception"+e);
		}
	}

	private void MatchKeyword()
	{
		try
		{
			if(pass.length()<=4)
			{
				System.out.println("Enter strong password");
			}

			else
			if(pass.equals(conPass))
			{
				Calendar calendar = new GregorianCalendar();
				System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
			    calendar = null;

				System.out.println("\nPlease Wait Encryption Process working............");

				keyword = pass;
				y=keyword.length();
				x=(length%y==0)?((int)length/y):((int)length/y)+1;

               // System.out.println("Row:="+x+"colm:"+y);
				assignOrder();
				insertIntoArray();
				writeToFile();
				System.out.println("\nEncryption completed successfully");

				calendar = new GregorianCalendar();
				System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
			    calendar = null;

			}
			else
			{
				System.out.println("Your password does not match with each other");
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println("Exception" + ee);
		}

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




	private void insertIntoArray()
	{
		try
		{
			InputStream fin=new FileInputStream(filename);
			save=new int[x][y];
			int  ch=fin.read();
			while(ch!=-1)
			{
				for(int r=0;r<this.x;r++)
				{
					for(int c=0;c<this.y;c++)
					{
						save[r][c]=ch;
						ch=fin.read();
					}
				}
			}

			fin.close();
		}
		catch(OutOfMemoryError err)
		{
			err.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception"+e);
		}
	}


   	private void writeToFile()
	{
		try
		{
			Random random = new Random();

			int generate = 75288857;

			byte[] string = keyword.getBytes();
			try
			{
				for(int k = 0;k < keyword.length();k++)
				{
			   	string[k] = new Integer(string[k]^generate%256).byteValue();
				}
			}
           	catch(Exception ee)
	        {
				System.out.println(ee);
			}


			DataOutputStream d=new DataOutputStream(new FileOutputStream(dpath));
			d.writeBoolean(true);
			d.writeLong(length);
			d.writeInt(generate);
			d.writeUTF(new String(string));
			d.close();


			OutputStream dout=new FileOutputStream(dpath,true);
			for(int r=0;r<y;r++)
			{
				int temp=0;
				while(number[temp]!=r || temp>=y)
					temp++;
				for(int c=0;c<x;c++)
				{
					dout.write(save[c][temp]);
				}

			}
			dout.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception"+e);
		}
	}



	public static void main(String a[])
	 {

		String sname,dname,pass,conpass;

		try
     	 {
	     	  sname=a[0];
			  dname=a[1];
			  pass=a[2];
		      conpass=a[3];

			  EncryptionSerial obj=new EncryptionSerial(sname,dname,pass,conpass);

	     }

        catch(Exception e)
	     {
	     	  e.printStackTrace();
		   	  System.out.println("Exception"+e);
	     }

	  }


}