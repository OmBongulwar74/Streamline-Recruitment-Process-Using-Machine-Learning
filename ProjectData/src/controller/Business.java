package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ro.manoli.crypto.abe.kp.StartABE;
import service.LoginService;
import util.EMail;
import util.GeneratePassword;
import bean.FileBean;
import bean.RegBean;
import db.DAOQuires;

/**
 * Servlet implementation class in
 */
public class Business extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     String op = "";
		String nextpath="";
		String UPLOAD_DIRECTORY = "C:";
		String action=request.getParameter("action");
		System.out.println("Action="+action);
		HttpSession session = request.getSession(true);
		if("changepwd".equals(action)){
			System.out.println("In Change Password");
			LoginService ls = new LoginService();
			int noofrowsaffected=ls.changePwd(request,(String)session.getAttribute("emailid"));
			System.out.println(session.getAttribute("emailid"));
			if(noofrowsaffected>0){
				request.setAttribute("message", "Password Change Successfully");
			}
			else{
				request.setAttribute("message", "Current Password does not match");
			}

			nextpath="/Changepassword.jsp";
			
		}
		else
			if("download".equals(action))
			{	ArrayList<FileBean> filelist = null;
				 session = request.getSession(true);
				File folder = new File("C://"+session.getAttribute("emailid")+"//Encrypt");
				if(folder != null){
				File[] listOfFiles = folder.listFiles();
				 filelist=new ArrayList<FileBean>();
				    for (int i = 0; listOfFiles !=null && i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  FileBean bean= new FileBean();
				    	  System.out.println(listOfFiles[i].getName());
				    	  bean.setFilename(listOfFiles[i].getName());
				    	  bean.setFilesize(listOfFiles[i].length()/(1024L ));
				    	  filelist.add(bean);
				        
				      } 
				    }
				}
				request.setAttribute("filelist", filelist);				
				nextpath="/Download.jsp";	
			}
		else{
			 double startTime = System.currentTimeMillis();
		String email =(String) session.getAttribute("emailid");
		System.out.println("Path="+session.getAttribute("emailid"));
		File file = new File(UPLOAD_DIRECTORY+"//"+session.getAttribute("emailid"));
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		 String name=null;
		 UPLOAD_DIRECTORY = UPLOAD_DIRECTORY +"\\"+ session.getAttribute("emailid");
		
		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
           
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                         name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }else
                    {
                    	if(!("parallel".equals(op) || "serial".equals(op))){
                    	 op = item.getString();
                    	System.out.println(op+"------");
                    	}
                    }
                }
           
               //File uploaded successfully
                
                // create Encrypt folder
                 file = new File(UPLOAD_DIRECTORY+"//Encrypt");
        		if (!file.exists()) {
        			if (file.mkdir()) {
        				System.out.println("Directory is created!");
        			} else {
        				System.out.println("Failed to create directory!");
        			}
        		}
        		
        		String path = UPLOAD_DIRECTORY + File.separator + name;
/*
                try {
                    byte[] encoded = Files.readAllBytes(Paths.get(path));
                	StartABE.startAbe(encoded, email);        
                } catch (IOException e) {

                }*/
                //Encrypt the File
        		System.out.println(UPLOAD_DIRECTORY +"//"+  name);
        		System.out.println(UPLOAD_DIRECTORY+"//Encrypt//" +  name);
        	//	CryptoUtils.encrypt("0123456789abcdef",new File(UPLOAD_DIRECTORY +"//"+  name) ,new File(UPLOAD_DIRECTORY+"//Encrypt//" +  name));
        	
        		String a = GeneratePassword.randomPasswordIs();
        	
        		EnParPar.startParallel(UPLOAD_DIRECTORY +"//"+  name,UPLOAD_DIRECTORY+"//Encrypt//" +  name,a,a);
        		System.out.println("Parallel");
        		System.out.println("success");
        		RegBean rb = new RegBean();
        		rb.setEmailid((String)session.getAttribute("emailid"));
        		rb.setPassword(a);
        		rb.setFname(name);
        		EMail mail =new EMail();
    			mail.sendMailFile(rb);
    		
        		
        		double bytes = file.length();
        	/*	if("serial".equals(op)){
        			EncryptionSerial obj=new EncryptionSerial(UPLOAD_DIRECTORY +"//"+  name,"D:"+"//file//" +  name,"Abc@1234","Abc@1234");
        			System.out.println("Serial");
        		}
        		else{
            		
            		EnParPar.startParallel(UPLOAD_DIRECTORY +"//"+  name,"D:"+"//file//" +  name,"Abc@1234","Abc@1234");
            		System.out.println("parallel");
            		}*/
        			double kilobytes = (bytes / 1024);
     	    	   double endTime   = System.currentTimeMillis();
     	  		 long totalTime = Math.round(endTime - startTime);
        	/*	 try 
        		 {
        		         URL url = new URL("http://www.google.com");
        		  
        		         URLConnection connection = url.openConnection();
        		         connection.connect();   
        		  
        		         System.out.println("Internet Connected");   
        		             
        		 
        		  file = new File("d:/file/");
        		   
        	        File[] files = file.listFiles();

        	 
        	    	   for(File f: files){
        	    		   

        	           	Runtime.getRuntime().exec("  cmd /c start D:\\bat.bat "+f.getName()+" D:/file/"+f.getName());  
        	           	System.out.println("success");
                
        	    	   }
        		 }catch (Exception e){
       		      
            		 System.out.println("Sorry, No Internet Connection");     
            		                                                             
            		 } 
        	    	   */
        	   	
        	  		 System.out.println(totalTime+"------------------");
        	  		 new DAOQuires().insertDBQuires(name,Math.round(kilobytes)+"",totalTime+"",op);        
            	}catch(Exception e){
         
            		e.printStackTrace();
         
            	}
                
		}
                
                
                
         
               request.setAttribute("message", "File Uploaded Successfully");
         
		nextpath="/Portal.jsp";
		
		}
        request.getRequestDispatcher(nextpath).forward(request, response);
     


		    }
}
