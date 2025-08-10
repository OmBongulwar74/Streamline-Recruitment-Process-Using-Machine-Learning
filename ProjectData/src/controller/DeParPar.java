package controller;

import java.io.*;
import java.util.*;

class Decryption extends Thread
{
	public static long read_length,length,cnt=0L,count=0L;
	public static int skip_bytes,number[],save[][],x,y,flag;
	public static String filename,dpath,keyword;
	int crow,c,temp=0,generate;
	String  original_keyword, timepass,pass;
	RandomAccessFile rcf;
	InputStream fin;


	Decryption(){}

	public void matdesign(int row,int col,String s,String d,String pass,long len,int skipby)
	{
		 try
		 {
		 save=new int [col][row];
		 flag=1;
		 filename = s;
		 dpath = d;
		 keyword=pass;
		 length=len;
		 skip_bytes=skipby;
		 x=col;
		 y=row;
		 assignOrder();

	}

	   catch(OutOfMemoryError err)
	   	{
	   	    err.printStackTrace();
	   	    System.out.println("in desgin mat");
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



	 public void run()
		   {
			   try
			   {
	                      getIntoArray();
	                      System.out.println("reads success: "+getName());
		   				  write2file();
						  System.out.println("\tWrite success: "+getName());

			   }

		catch(Exception e){}

	}





	private void getIntoArray()
	{

		try
				{

					fin=new FileInputStream(filename);

					fin.skip(skip_bytes+((crow*y)));

					int ch=fin.read();

					int temp=0;

						while(number[temp]!=crow || temp>=x)
								temp++;


						for(int c=0;c<y;c++)
							{
					   		    save[temp][c]=ch;
								ch=fin.read();
							}

					fin.close();


				}
				catch(Exception e){}


	}



public void write2file()
   {

		try
   		{
       		rcf=new RandomAccessFile(this.dpath,"rw");

            rcf.seek(crow);

			for(int c=0;c<y;c++)
			{
			   if(filename.charAt(filename.length()-1)!='t')
			   {
			      rcf.write((char)save[crow][c]);
				  rcf.seek(crow+x+(x*c));
			   }

              else
			      if(save[crow][c]!=255)
			      {
			        rcf.write((char)save[crow][c]);
				    rcf.seek(crow+x+(x*c));
			      }
		    }
	}
		catch(Exception e){}
  }
}





public class DeParPar
{

	public static void main(String a[])
		{

				String sname,dname,pass,original_keyword,timepass;
				int plength,skip_byte,generate;
				long flength,read_length;
				boolean flag;

				BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

				try
			    {

				   sname=a[0];
				   dname=a[1];
				   pass=a[2];


				   DataInputStream din=new DataInputStream(new FileInputStream(sname));

				   flag = din.readBoolean();
				   if(!flag)
				   	{
				   	    System.out.println("Modified file");

					}
					else
					{
				   		read_length = din.readLong();
			   			generate = din.readInt();
			   			timepass = din.readUTF();


				   		byte[] string = timepass.getBytes();
				   			for(int k = 0;k < timepass.length();k++)
				   			{
				   			   string[k] = new Integer(string[k]^generate%256).byteValue();
   			               }

				   			original_keyword = new String(string);

				   			plength=original_keyword.length();

				   			skip_byte = 15 + plength;

				   			din.close();

				   			File f=new File(sname);

				   			flength=(int)f.length();

				   			if(flength==0)
				   			{
				   				System.out.println("File is Empty");
				   			}

				   			if(pass.equals(original_keyword))
				   		{

                    		Calendar calendar = new GregorianCalendar();
							int hours=calendar.get(Calendar.HOUR);
							int minute = calendar.get(Calendar.MINUTE);
							int second = calendar.get(Calendar.SECOND);
							System.out.println("\n\n=======================>> "+hours+":"+minute+":"+second);

							int x=plength;
                    		int y=(read_length%x==0)?((int)read_length/x):((int)read_length/x)+1;

						try
						{

							Decryption obj=new Decryption();

							obj.matdesign(y,x,sname,dname,pass,read_length,skip_byte);

	                   		Decryption e[]=new Decryption[x];


                    		for(int i=0;i<x;i++)
							{
								  e[i]=new Decryption();
								  e[i].crow=i;
								  e[i].start();
							}
								for(int i=0;i<x;i++)
							    e[i].join();


				   			System.out.print("Decryption completed");

				   			Calendar calendar1 = new GregorianCalendar();
				   			hours=calendar1.get(Calendar.HOUR);
				   			minute = calendar1.get(Calendar.MINUTE);
				   			second = calendar1.get(Calendar.SECOND);
				   			System.out.println("\n\n=======================>> "+hours+":"+minute+":"+second);

					      }
					      catch(OutOfMemoryError err)
						  	   	{
						  	   	    err.printStackTrace();
						  	   	    System.out.println("in desgin mat5555");
	    						}
			      		  catch(Exception e){}

			      		}

			     			else
			     		  System.out.println("Password not match");
					}
				}
	            catch(Exception e){}
	    }

   }


