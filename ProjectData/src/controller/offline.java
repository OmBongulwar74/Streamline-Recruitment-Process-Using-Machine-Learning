package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FileBean;

/**
 * Servlet implementation class offline
 */
public class offline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public offline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ArrayList<FileBean> filelist = null;
		 session = request.getSession(true);
		File folder = new File("D://File");
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
		String nextpath="/Download.jsp";
		request.getRequestDispatcher(nextpath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
