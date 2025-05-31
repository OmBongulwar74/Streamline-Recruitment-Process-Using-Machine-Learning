<%@page import="java.util.ArrayList"%>
<%@page import="bean.PostBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully Posted</title>
<link href="../html/css.css" rel="stylesheet" type="text/css" />
	<link href="../css/registration.css" rel="stylesheet" type="text/css" />
	 <link rel="stylesheet" href="../css/framewarp.css" />
	 	
</head>
<body>
<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>
	
	
	<fieldset >
					<legend><span>Posted Successfully</span></legend>
					<ol >
						<li >
						<a href="<%=request.getContextPath()%>/BussinessController?button=view&value=<%=session.getAttribute("query")%>"><font size="4px"> <%=session.getAttribute("query") %></font></a></li></ol>

	
	
		<ol><li>
		
		
		<%if(session!=null) {if("Patient".equals(session.getAttribute("userType"))){%>
				<a href="../JSP Pages/postpage.jsp"><input class="Registrationinput" id="PostNew"   type="button"  value="New Post"/></a><%}else if("Doctor".equals(session.getAttribute("userType"))){ %>
								<a href="../JSP Pages/commentWindow.jsp" class="button1" id="b2"><input class="Registrationinput" id="Comment"   type="button"  value="Comment"/></a>
								<%}} %>
						 <a href="<%=request.getContextPath()%>/BussinessController?button=viewallpost"><input class="Registrationinput" id="viewpost"   type="button"  value="View All Post"/></a>
					 
					</li>
					</ol>
				</fieldset>
									
	<%if(request.getSession(false)!=null)
		{
		ArrayList<String> comments=(ArrayList<String>)session.getAttribute("comments");
		if(comments!=null){
		%>
				<fieldset >
					<legend><span>View Post</span></legend>
					<ol >
		
		<h2><%=session.getAttribute("query") %></h2>
		
		
		
		<%if(comments.size()==0)
		{%>
		<h5> No comments yet</h5>
		
	<%}else{
	for(int i=0;i<comments.size();i++){ %>
		<h4><%=comments.get(i)%></h4>
<%	}}	} }%>

	
</ol>
	
				
				
				</form>


<%@ include file="../html/closeContent.html" %>


<%@ include file="../html/Footer.html" %>
 <script src="../js/comment.js"></script>
        <script src="../js/jquerypp.custom.js"></script>
        <script src="../js/framewarp.js"></script>
        <script src="../js/script.js"></script>
</body>
</html>