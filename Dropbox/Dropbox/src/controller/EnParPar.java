package controller;
import java.io.*;
import java.util.*;

class Encryption extends Thread
{
	public static int number[],skip,x,y,save[][];
	public static String keyword,spath,dpath;
	int temp=0,ccolm,c;
	long size,cnt;
	RandomAccessFile rcf;
	InputStream input;

	Encryption()
	{

	}

	public void matdesign(int row,int col,String s,String d,String pass,int skipby)
	{
		try
		{
			save=new int [row][col];
		 	spath=s;
		 	dpath=d;
		 	skip=skipby;
		 	keyword=pass;
		 	x=row;
		 	y=col;
			assignOrder();
		}

		catch(OutOfMemoryError err)
		{
			err.printStackTrace();
	  		System.out.println("in desgin mat");
		}
	}


	public void run()
	{
		try
		{
			insertIntoArray();
           // System.out.println("reads success: "+getName());
		    write2file();
            //System.out.println("\tWrite success: "+getName());
		}

		catch(Exception e)
		{
			System.out.println(e);
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
			InputStream input=new FileInputStream(spath);
			c=0;
			input.skip(ccolm);
			int ch=input.read();
			while(x>c)
			{
				save[c][ccolm]=ch;
				System.out.print((char)ch);
				c++;
				input.skip(y-1);
				ch=input.read();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void write2file()
   	{
   		try
   		{
   			rcf=new RandomAccessFile(this.dpath,"rw");
   			rcf.seek(skip+(ccolm*this.x));
   			int temp=0;
			while((int)number[temp]!=ccolm || temp>=y)
   			temp++;
			for(int c=0;c<x;c++)
			{
				rcf.write((char)save[c][temp]);
			}
   	   }

   	   catch(Exception e)
   	   {
		   e.printStackTrace();
	   }
   }

   public void printmat()
   {
    try
   {
    for(int i=0;i<x;i++)
    {
      System.out.println("\n");
       for(int j=0;j<y;j++)
      {
         System.out.println("\t"+save[i][j]);
      }
     }
   }
   catch(Exception e){}
   }
}


public class EnParPar
{
	  public static void startParallel(String sname,String dname,String pass,String conPass)
	 {
		 long flength;
		 int plength,start1,end1;

		 try
		 {
		

   			 if(pass.length()<=4)
   			 	System.out.println("Enter strong password");
   			 else if(pass.equals(conPass))
   			 {
				 int generate = 75288857;
				 File f=new File(sname);
				 flength=f.length();
				 plength=pass.length();
				 System.out.println("File Length:="+" "+f.length());
				 if(flength==0)
				 {
					 System.out.println("Make sure that the file is not empty or Read Only");
				 }
				 else
				 {
					 Calendar calendar = new GregorianCalendar();
					 System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
					 calendar = null;

					 byte[] string = pass.getBytes();

					 for(int k = 0;k < pass.length();k++)
					 string[k] = new Integer(string[k]^generate%256).byteValue();

					 DataOutputStream d=new DataOutputStream(new FileOutputStream(dname));
					 d.writeBoolean(true);
					 d.writeLong(f.length());
					 d.writeInt(generate);
					 d.writeUTF(new String(string));
					 d.close();

					 int row=(flength%plength==0)?((int)flength/plength):((int)flength/plength)+1;
					 int colm=plength;
					 System.out.println("\nRow:= "+row+"\tColm:="+colm);

					 int skip = 15 + plength;

					 try
					 {
						 Encryption obj=new Encryption();
						 obj.matdesign(row,colm,sname,dname,pass,skip);
						 Encryption e[]=new Encryption[colm];
						 for(int i=0;i<colm;i++)
						 {
							 e[i]=new Encryption();
							 e[i].ccolm=i;
							 e[i].start();
						 }

						 for(int i=0;i<colm;i++)
						 {
							 e[i].join();
						 }
						obj.printmat();
						 System.out.println("Encryption completed successfully");

						 calendar = new GregorianCalendar();
						 System.out.println("\n\n=======================>> "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
					 }

					 catch(OutOfMemoryError err)
					 {
						 err.printStackTrace();
						 System.out.println("OutOfMemoryError");
					 }
				 }
			 }

			 else
			 	System.out.println("Your password does not match with each other");
		 }

		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
 }






