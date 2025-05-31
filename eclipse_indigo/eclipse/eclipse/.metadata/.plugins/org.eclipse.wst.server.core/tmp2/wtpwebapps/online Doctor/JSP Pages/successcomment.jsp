<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../html/css.css" rel="stylesheet" type="text/css" />
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<title>Comment Posted</title>
</head>
<body>
<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>

<label class="Registrationlabel"  class="Registrationlabelrequired">Comment Posted successfully</label>
<a href="/online_Doctor//BussinessController?button=view&value="+<%=session.getAttribute("query")%>><input class="Registrationinput" type="button"  value="Back" /></a>

<%@ include file="../html/closeContent.html" %>


<%@ include file="../html/Footer.html" %>
</body>
</html>