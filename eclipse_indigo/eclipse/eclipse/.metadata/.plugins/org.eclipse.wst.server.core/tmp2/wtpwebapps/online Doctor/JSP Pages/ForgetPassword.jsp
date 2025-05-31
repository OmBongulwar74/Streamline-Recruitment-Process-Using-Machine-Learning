<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<link href="../html/css.css" rel="stylesheet" type="text/css" />
</head>

<body>

<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>


	<form action="<%=request.getContextPath()%>/Controller" method="post" >
	
	
	<input type="hidden" value="forget password" name="button">
	
				<fieldset >
					<legend><span>Forget Password</span></legend>
					<ol>
					<li>
					<%String success=(String)session.getAttribute("fpassword");
					if("false".equals(success))
					{
						%>
						<label><font size="3px" color="red">Incorrect Email id</font></label>
						<%}
					else if ("true".equals(success))
					{%>
					<label><font size="3px" color="green">Password send to your email id. Please check in Inbox or Spam</font></label>
					<%} %>
					</li>
					
						<li><label class="Registrationlabel"  class="Registrationlabelrequired">Email id<span>*</span></label>
							<input class="Registrationinput" name="Emailid"  type="text" id="emailid" />
			
								
						</li>
						<li>
							<label class="Registrationlabel" class="Registrationlabelrequired">Verify Email id<span>*</span></label>	
							<input class="Registrationinput" type="text" id="VEmailid" name="vemailid" />
						</li>
						
				
					</ol>
				</fieldset>
	<fieldset>
					<input class="Registrationinput"  style="text-align: right;" type="submit"  value="Get Password"/>					</label>
				</fieldset>
			</form>
<%@ include file="../html/closeContent.html" %>


<%@ include file="../html/Footer.html" %>

</body>
</html>