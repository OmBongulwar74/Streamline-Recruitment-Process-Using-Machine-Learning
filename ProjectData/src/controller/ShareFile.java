package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DAOQuires;

/**
 * Servlet implementation class ShareFile
 */
public class ShareFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShareFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getParameter("action");
		HttpSession session = request.getSession(true);
		String nextpath="";
		System.out.println("-------------------------");
		if("Share".equals(action))
		{
		String sharewith=request.getParameter("sharename");
		System.out.println(sharewith);
		String filename=request.getParameter("filename");
		System.out.println(filename);
		String path="c:\\"+sharewith+"\\";
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		 file = new File(path +"\\Encrypt\\");
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		path = path +"\\Encrypt\\";
		int i;
		FileInputStream fin;
		FileOutputStream fout;
		try {
		// open input file
		try {
			System.out.println("c:\\"+session.getAttribute("emailid")+"\\Encrypt\\"+filename);
		fin = new FileInputStream("c:\\"+session.getAttribute("emailid")+"\\Encrypt\\"+filename);
		} catch(FileNotFoundException e) {
		System.out.println("Input File Not Found");
		return;
		}
		// open output file
		try {
			fout = new FileOutputStream(path+filename);
		} catch(FileNotFoundException e) {
		System.out.println("Error Opening Output File");
		return;
		}
		} catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("Usage: CopyFile From To");
		return;
		}
		// Copy File
		try {
		do {
		i = fin.read();
		if(i != -1) fout.write(i);
		} while(i != -1);
		} catch(IOException e) {
		System.out.println("File Error");
		
		}
		fin.close();
		fout.close();
		nextpath="/FileShared.jsp";
		}
		else{
		String filename= request.getParameter("filename");
		ArrayList<String> userlist=new ArrayList<String>();
		
		DAOQuires db = new DAOQuires();
		userlist=db.getUserList();
		userlist.remove((String)session.getAttribute("emailid"));
		request.setAttribute("userlist", userlist);
		System.out.println(userlist.size());
		
		request.setAttribute("filename", request.getParameter("filename"));
		nextpath="/ShareFile.jsp";
		}
		RequestDispatcher rd = request
				.getRequestDispatcher(nextpath);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
