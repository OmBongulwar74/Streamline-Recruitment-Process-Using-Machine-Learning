package controller;

import java.io.*;  
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;  
import javax.servlet.http.*;  

import ro.manoli.crypto.abe.kp.StartABE;
import service.CryptoException;
import service.CryptoUtils;
  
public class FileDownloader extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
	
  HttpSession session = request.getSession(true);
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
System.out.println(":In get");
String filename = (String)request.getParameter("filename");
System.out.println("in"+filename);
String DOWNLOAD_DIRECTORY= "c://"+session.getAttribute("emailid")+"//";

  

File file = new File(DOWNLOAD_DIRECTORY+ "//Decrypt");
if (!file.exists()) {
	if (file.mkdir()) {
		System.out.println("Directory is created!");
	} else {
		System.out.println("Failed to create directory!");
	}
}

// Decrpt file and store in Decrypt folder

try {
	//CryptoUtils.decrypt("0123456789abcdef",new File(DOWNLOAD_DIRECTORY+"//Encrypt//"+filename), new File(DOWNLOAD_DIRECTORY+"//Decrypt//"+filename));
	String a = request.getParameter("a");
	 DecryptionSerial obj=new DecryptionSerial(DOWNLOAD_DIRECTORY+"//Encrypt//"+filename,DOWNLOAD_DIRECTORY+"//Decrypt//"+filename,a);
	 String path = DOWNLOAD_DIRECTORY + File.separator + filename;

   /*  try {
         byte[] encoded = Files.readAllBytes(Paths.get(path));
     	StartABE.DecryptAbe(encoded,(String) session.getAttribute("emailid"));        
     } catch (IOException e) {

     }*/
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
String filepath = "c://"+session.getAttribute("emailid")+"\\Decrypt\\";
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) {  
out.write(i);   
}   
fileInputStream.close();   
out.close();   
}  

}
