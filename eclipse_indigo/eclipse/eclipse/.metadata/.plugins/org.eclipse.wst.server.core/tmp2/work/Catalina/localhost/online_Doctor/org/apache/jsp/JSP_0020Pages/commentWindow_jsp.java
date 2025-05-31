package org.apache.jsp.JSP_0020Pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class commentWindow_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <title>Message Embed Page</title>\r\n");
      out.write("        \r\n");
      out.write("        <!-- The stylesheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/commentwindow.css\" />\r\n");
      out.write("        \r\n");
      out.write("        <style>\r\n");
      out.write("\r\n");
      out.write("        h1{\r\n");
      out.write("            text-align:center;\r\n");
      out.write("            margin-top:160px;\r\n");
      out.write("            font-weight:normal;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #close{\r\n");
      out.write("            display:block;\r\n");
      out.write("            width:100px;\r\n");
      out.write("            margin:20px auto;\r\n");
      out.write("            text-align:center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #msgbox{\r\n");
      out.write("            font:inherit;\r\n");
      out.write("            font-size:14px;\r\n");
      out.write("            padding:7px 12px;\r\n");
      out.write("            border-radius:3px;\r\n");
      out.write("            margin-right:3px;\r\n");
      out.write("            border:1px solid #bbb;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #sendmsg{\r\n");
      out.write("            font-size:14px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .center{\r\n");
      out.write("            padding:30px 0 18px 0;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("          <script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body class=\"framePage\">\r\n");
      out.write("\r\n");
      out.write("        <h1>Please write your comment</h1>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"center\">\r\n");
      out.write("            <input type=\"text\" id=\"msgbox\" placeholder=\"Enter your comment here\" />\r\n");
      out.write("            <a class=\"button1\" id=\"sendmsg\" onclick=\"sendComment();frameWarp.hide();\">Send</a>\r\n");
      out.write("        </div>\r\n");
      out.write("<p id=\"path\" style=\"visibility: hidden;\" >");
      out.print(request.getContextPath());
      out.write("</p>\r\n");
      out.write("        <a href=\"#\" class=\"button2\" id=\"close\" onclick=\"frameWarp.hide();\">Close Window</a>\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("function sendComment()\r\n");
      out.write("{\r\n");
      out.write("\tvar path=document.getElementById('path').innerHTML;\r\n");
      out.write("\talert(path);\r\n");
      out.write("\t window.location.href=path+\"/BussinessController?button=comment&value=\"+msgbox.value;\r\n");
      out.write("\t \r\n");
      out.write("\t}\r\n");
      out.write("            // Using plain javascript to listen for clicks on the send button. You can use jQuery as well.\r\n");
      out.write("\r\n");
      out.write("            var msgbox = document.getElementById('msgbox');\r\n");
      out.write("\r\n");
      out.write("            document.getElementById('sendmsg').addEventListener('click',function(){\r\n");
      out.write("            \t\r\n");
      out.write("                frameWarp.sendMessage(msgbox.value);\r\n");
      out.write("\r\n");
      out.write("                // Emptying the msgbox\r\n");
      out.write("                msgbox.value = '';\r\n");
      out.write("               \r\n");
      out.write("                return false;\r\n");
      out.write("            },false);\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
