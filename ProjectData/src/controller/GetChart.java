package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.BarChart;
import bean.ChartData;
import db.DAOQuires;;
public class GetChart
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public GetChart() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    DAOQuires db = new DAOQuires();
    
    ArrayList<ChartData> chart = db.getChart();
    BarChart b = new BarChart(getServletContext().getRealPath("/"));
    b.createChart(chart, "Chart");
    HttpSession session = request.getSession();
    String type = (String)session.getAttribute("type");
    String nextPath = "/ShowChart.jsp";
    request.setAttribute("a", "a");
    RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPath);
    rd.forward(request, response);
  }
}
