package org.apache.jsp.JSP_0020Pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class invalidChat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/JSP Pages/../JSP Pages/Header.jsp");
    _jspx_dependants.add("/JSP Pages/../html/content.html");
    _jspx_dependants.add("/JSP Pages/../html/closeContent.html");
    _jspx_dependants.add("/JSP Pages/../html/Footer.html");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Invalid Chat</title>\r\n");
      out.write("<link href=\"../html/css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
Boolean isSuccess=(Boolean)session.getAttribute("isSuccess"); 
String userType= (String)session.getAttribute("userType");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"../html/login/style.css\">\r\n");
      out.write("\r\n");
      out.write("      ");

      String registration=(String)request.getParameter("registration");
      
      if(isSuccess== null) { 
      if(!("true".equals(registration)))
      {
      
      out.write("\r\n");
      out.write("      <script type=\"text/javascript\" src=\"../html/login/js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"../html/login/js/jquery.leanModal.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("  $('#loginform').submit(function(e){\r\n");
      out.write("    return false;\r\n");
      out.write("  });\r\n");
      out.write("  \r\n");
      out.write("  $('#modaltrigger').leanModal({ top: 110, overlay: 0.3, closeButton: \".hidemodal\" });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("     ");
}}else if(isSuccess!= null){
     if(isSuccess==false){
      out.write("\r\n");
      out.write("      <script type=\"text/javascript\" src=\"../html/login/js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"../html/login/js/jquery.leanModal.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("      ");
}}
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#sddm\r\n");
      out.write("{\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tz-index: 30}\r\n");
      out.write("\r\n");
      out.write("#sddm li\r\n");
      out.write("{\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tfont: bold 11px arial}\r\n");
      out.write("\r\n");
      out.write("#sddm li a\r\n");
      out.write("{\tdisplay: block;\r\n");
      out.write("\tmargin: 0 1px 0 0;\r\n");
      out.write("\tpadding: 4px 10px;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tcolor: #FFF;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\ttext-decoration: none}\r\n");
      out.write("\r\n");
      out.write("#sddm li a:hover\r\n");
      out.write("{\r\n");
      out.write("background-color: #82CAFF;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("#sddm div\r\n");
      out.write("{\tposition: absolute;\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tbackground: #EAEBD8;\r\n");
      out.write("\tborder: 1px solid #5970B2}\r\n");
      out.write("\r\n");
      out.write("\t#sddm div a\r\n");
      out.write("\t{\tposition: relative;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tpadding: 5px 10px;\r\n");
      out.write("\t\twidth: auto;\r\n");
      out.write("\t\twhite-space: nowrap;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tbackground: #EAEBD8;\r\n");
      out.write("\t\tcolor: #2875DE;\r\n");
      out.write("\t\tfont: 11px arial}\r\n");
      out.write("\r\n");
      out.write("\t#sddm div a:hover\r\n");
      out.write("\t{\tbackground: #49A3FF;\r\n");
      out.write("\t\tcolor: #FFF}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("\r\n");
      out.write("  var timeout\t= 500;\r\n");
      out.write("  var closetimer\t= 0;\r\n");
      out.write("  var ddmenuitem\t= 0;\r\n");
      out.write("\r\n");
      out.write("  // open hidden layer\r\n");
      out.write("  function mopen(id)\r\n");
      out.write("  {\t\r\n");
      out.write("  \t// cancel close timer\r\n");
      out.write("  \tmcancelclosetime();\r\n");
      out.write("\r\n");
      out.write("  \t// close old layer\r\n");
      out.write("  \tif(ddmenuitem) ddmenuitem.style.visibility = 'hidden';\r\n");
      out.write("\r\n");
      out.write("  \t// get new layer and show it\r\n");
      out.write("  \tddmenuitem = document.getElementById(id);\r\n");
      out.write("  \tddmenuitem.style.visibility = 'visible';\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("  // close showed layer\r\n");
      out.write("  function mclose()\r\n");
      out.write("  {\r\n");
      out.write("  \tif(ddmenuitem) ddmenuitem.style.visibility = 'hidden';\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  // go close timer\r\n");
      out.write("  function mclosetime()\r\n");
      out.write("  {\r\n");
      out.write("  \tclosetimer = window.setTimeout(mclose, timeout);\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  // cancel close timer\r\n");
      out.write("  function mcancelclosetime()\r\n");
      out.write("  {\r\n");
      out.write("  \tif(closetimer)\r\n");
      out.write("  \t{\r\n");
      out.write("  \t\twindow.clearTimeout(closetimer);\r\n");
      out.write("  \t\tclosetimer = null;\r\n");
      out.write("  \t}\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  // close layer when click-out\r\n");
      out.write("  document.onclick = mclose; \r\n");
      out.write("  \r\n");
      out.write("  </script>\r\n");
      out.write("  <!-- jQuery plugin leanModal under MIT License http://leanmodal.finelysliced.com.au/ -->\r\n");
      out.write("<table width=\"780\" align=\"center\"  >\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_02.gif); background-repeat:repeat-x; background-position:top;\"><table width=\"724\"  align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td ><table width=\"100%\"  >\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td ><table width=\"724\"  >\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"64\"><img src=\"../images/index_04.gif\" width=\"170\" height=\"64\" alt=\"\" /></td>\r\n");
      out.write("                <td width=\"660\" align=\"left\" valign=\"bottom\" style=\"padding-left:2px;\"><table width=\"539\"  >\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td  class=\"menu\"><a href=\"Mainpage.jsp\">Home</a></td>\r\n");
      out.write("                      <td  class=\"menu\"><a href=\"#\">About us</a></td>\r\n");
      out.write("                      <td  class=\"menu\">\r\n");
      out.write("                      <ul id=\"sddm\">\r\n");
      out.write("    <li>\r\n");
      out.write("            ");
if ("Patient".equals(userType)){
      out.write("\r\n");
      out.write("            <a href=\"#\" \r\n");
      out.write("        onmouseover=\"mopen('m1')\" \r\n");
      out.write("        onmouseout=\"mclosetime()\"><font class=\"menu\">Service</font></a>\r\n");
      out.write("        <div id=\"m1\" \r\n");
      out.write("            onmouseover=\"mcancelclosetime()\" \r\n");
      out.write("            onmouseout=\"mclosetime()\">\r\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath());
      out.write("/BussinessController?button=doctorList\">Take Appointment</a>\r\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath());
      out.write("/BussinessController?button=viewallappointment\">Online Chat</a>\r\n");
      out.write("        <a href=\"../JSP Pages/postpage.jsp\">Post Query</a>\r\n");
      out.write("        <a href=\"../JSP Pages/ChangePassword.jsp\">Change Password</a>\r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath());
      out.write("/BussinessController?button=viewallpost\">View All Post</a>\r\n");
      out.write("         ");
} else if("Doctor".equals(userType)) { 
         
      out.write("<a href=\"#\" \r\n");
      out.write("        onmouseover=\"mopen('m1')\" \r\n");
      out.write("        onmouseout=\"mclosetime()\"><font class=\"menu\">Service</font></a>\r\n");
      out.write("        <div id=\"m1\" \r\n");
      out.write("            onmouseover=\"mcancelclosetime()\" \r\n");
      out.write("            onmouseout=\"mclosetime()\">\r\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath());
      out.write("/BussinessController?button=viewallappointment\">Online Chat</a>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath());
      out.write("/BussinessController?button=viewallpost\">View All Post</a>\r\n");
      out.write("        <a href=\"../JSP Pages/ChangePassword.jsp\">Change Password</a>\r\n");
      out.write("         \r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("                     </td> \r\n");
      out.write("                      \r\n");
      out.write("                      \r\n");
      out.write("                      <td class=\"menu\"><a href=\"#\">Patients</a></td>\r\n");
      out.write("                      \r\n");
      out.write("     \r\n");
      out.write("                      ");
if(isSuccess!=null)
                      {
                    	  if(isSuccess.booleanValue()==true)
                    	  {
                    	  
      out.write("<td  class=\"menu\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Controller?button=logout\">Log out</a></td>\r\n");
      out.write("                          ");
}else{
                    	  
      out.write("\r\n");
      out.write("                      <td  class=\"menu\"><a href=\"#loginmodal\"  id=\"modaltrigger\">Login</a></td>\r\n");
      out.write("                     \r\n");
      out.write("  ");
}
                      }else{ 
      out.write("\r\n");
      out.write("                   <td  class=\"menu\"><a href=\"#loginmodal\"  id=\"modaltrigger\">Login</a></td>");
} 
      out.write("   \r\n");
      out.write("                      <td class=\"menu\"><a href=\"contact.html\">Contact us</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td ><table width=\"100%\"  >\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"3%\"  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_19.gif); background-repeat:repeat-y; background-position:left;\"><img src=\"../images/index_09.gif\" width=\"24\" height=\"10\" alt=\"\" /></td>\r\n");
      out.write("                <td width=\"30%\" rowspan=\"2\" ><img src=\"../images/index_10.gif\" width=\"218\" height=\"213\" alt=\"\" /></td>\r\n");
      out.write("                <td width=\"19%\" rowspan=\"2\" ><img src=\"../images/index_11.gif\" width=\"136\" height=\"213\" alt=\"\" /></td>\r\n");
      out.write("                <td width=\"44%\" rowspan=\"2\" ><table width=\"97%\"  >\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td ><img src=\"../images/index_12.gif\" width=\"316\" height=\"53\" alt=\"\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td ><a href=\"Mainpage.jsp\"><img src=\"../images/index_17.gif\" alt=\"\" width=\"316\" height=\"58\"  /></a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td ><img src=\"../images/index_18.gif\" width=\"316\" height=\"102\" alt=\"\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("                <td width=\"4%\"  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_23.gif); background-repeat:repeat-y; background-position:right;\"><img src=\"../images/index_13.gif\" width=\"30\" height=\"10\" alt=\"\" /></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_19.gif); background-repeat:repeat-y; background-position:left;\">&nbsp;</td>\r\n");
      out.write("                <td width=\"4%\"  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_21.gif); background-repeat:repeat-y; background-position:right;\">&nbsp;</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          \r\n");
      out.write("                  \r\n");
      out.write("                \r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("      \r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("  <div id=\"loginmodal\" style=\"display:none;\">\r\n");
      out.write("    <h1>User Login</h1>\r\n");
      out.write("    <form action=\"");
      out.print(request.getContextPath());
      out.write("/Controller\" name=\"loginform\" method=\"post\" >\r\n");
      out.write("      <label for=\"username\">Username:</label>\r\n");
      out.write("      <input type=\"text\" name=\"username\" id=\"username\" class=\"txtfield\" tabindex=\"1\">\r\n");
      out.write("      \r\n");
      out.write("      <label for=\"password\">Password:</label>\r\n");
      out.write("      <input type=\"password\" name=\"password\" id=\"password\" class=\"txtfield\" tabindex=\"2\">\r\n");
      out.write("      \r\n");
      out.write("      ");
 if(isSuccess!= null) 
      if(isSuccess==false)
      {
      out.write("\r\n");
      out.write("      <div><font size=\"2\" color=\"red\"> Invalid ID or password.<br>\r\n");
      out.write("Please try again using your full Yahoo ID. </font>  </div>\r\n");
      out.write("     ");
 
      }
      
    	  
    	  
      out.write("\r\n");
      out.write("      <div class=\"left\"><input type=\"submit\" name=\"button\" id=\"loginbtn\" class=\"flatbtn-blu hidemodal\" value=\"Log In\" tabindex=\"3\" onclick=\"document.form.submit();\">\r\n");
      out.write("      &nbsp;&nbsp;&nbsp; &nbsp;<a href=\"../JSP Pages/PatientRegistration.jsp?registration=true\"><input type=\"button\" name=\"button\" id=\"signbtn\" class=\"flatbtn-blu hidemodal\" value=\"Sign In\" tabindex=\"4\"></a></div>\r\n");
      out.write("      \r\n");
      out.write("      <div align =\"center\"><a href=\"../JSP Pages/ForgetPassword.jsp\">Forget Password</a></div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<table width=\"780\" align=\"center\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td bgcolor=\"#FFFFFF\"\r\n");
      out.write("\t\t\tstyle=\"background-image: url(../../images/index_02.gif); background-repeat: repeat-x; background-position: top;\"><table\r\n");
      out.write("\t\t\t\twidth=\"724\" align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\"><table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(../images/index_19.gif); background-repeat: repeat-y; background-position: left;\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding-top: 30px; padding-bottom: 6px;\"><table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"98%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"68%\" style=\"padding-left: 10px;\"><table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"92%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><table width=\"99%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("Chat Cannot be start do to following reasons:\r\n");
      out.write("\r\n");
      out.write("1. Appointment might be expired\r\n");
      out.write("2. Appointment might be in future\r\n");
      out.write("</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"780\"  align=\"center\" >\r\n");
      out.write("<tr>\r\n");
      out.write(" <td  bgcolor=\"#FFFFFF\" style=\"background-image:url(../images/index_02.gif); background-repeat:repeat-x; background-position:top;\"><table width=\"724\"  align=\"center\" >\r\n");
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("        <td ><table width=\"90%\"  align=\"center\" >\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"center\" style=\"padding-top:20px; padding-bottom:13px;\"><pre class=\"footer\"><a href=\"Mainpage.jsp\">Home</a>     |     <a href=\"content.html\">About us</a>     |     <a href=\"content.html\">Service</a>     |     <a href=\"content.html\">Patients</a>     |     <a href=\"content.html\">Advice</a>     |     <a href=\"contact.html\">Contact us</a></pre></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"copyright\" style=\"padding-bottom:19px;\">Copyright 2003-2007 Company name.com. All rights reserved</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("       </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
