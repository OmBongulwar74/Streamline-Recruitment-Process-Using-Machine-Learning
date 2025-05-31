<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Post</title>
<link href="../html/css.css" rel="stylesheet" type="text/css" />
	<link href="../css/registration.css" rel="stylesheet" type="text/css" />
	<%ArrayList<String> allPosts=(ArrayList<String>)session.getAttribute("allpost");%>
</head>
<body>
<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>



						
<table width="100%" height=100% border="1">
<%for(int i=0;i<allPosts.size();i++) {%>
<tr>
<td><label class="Registrationlabel" style="text-align: left;overflow: hidden;" width=5px><font size="4"><%=i+1 %></font></label></td>
<td><label class="Registrationlabel"  class="Registrationlabelrequired" style="text-align: left"><a href="<%=request.getContextPath()%>/BussinessController?button=view&value=<%=allPosts.get(i) %>"><font size="4"><%=allPosts.get(i) %></font></a></label></td>
</tr></font>
<%} %>
</table>
</ol>
</fieldset>
<%@ include file="../html/closeContent.html" %>
<%@ include file="../html/Footer.html" %>

</body>
</html>