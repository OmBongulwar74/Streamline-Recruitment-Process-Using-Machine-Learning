<%@page import="java.util.ArrayList"%>
<%@page import="bean.AppointmentDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat</title>

<link href="../html/css.css" rel="stylesheet" type="text/css" />
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<%ArrayList<AppointmentDetail> appbean=(ArrayList<AppointmentDetail>)(session.getAttribute("appointmentlist")); %>
<%ArrayList<String> chat=(ArrayList<String>) (session.getAttribute("Chat")); %>
</head>

<script type="text/javascript">
function addChat()
{
	document.getElementById("chatArea").value += "Me:"+document.getElementById("chat").value+"\n";
	//document.getElementById("chat").value="";
	}


</script>
<body  onload="<%=request.getContextPath()%>/ChatController">

<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>
<form action="<%=request.getContextPath()%>/ChatController" method="post" >
	<fieldset >
					<legend><span>Chat Application</span></legend>
					<ol >
						<li >
<textarea id="chatArea" rows="8" maxlength="1000" cols="100" style="font-size:15px;font-family:comic sans ms;width:100%; height:150%" name="chat" readonly="readonly" 


>
<%
if(chat!=null){
for(int i=0;i<chat.size();i++){%>
	<%=chat.get(i) %>
<%}} %>
</textarea>
	
	</li></ol>
		<ol><li>		
		
		<input class="Registrationinput" id="chat" name="Chat" type="text" style="width: 90%"/>
		<input class="Registrationinput" id="sendChat"   type="Submit"  value="Send" onclick="addChat();"/>
					</li>
					</ol>
				</fieldset>
				
<input type="hidden" name="fromemailid" value=<%=(session.getAttribute("userName"))%>>
<%int i=Integer.parseInt(request.getParameter("button"));%>
<input type="hidden" name = "startDate" value=<%=appbean.get(i).getStartDate()%>>
<input type="hidden" name = "endTime" value=<%=appbean.get(i).getStartTime()%>> 
<input type="hidden" name="button" value=<%=i%>>
<input type="hidden" name="button1" value=send>
<input type="hidden" name="toemailid" value=<%=appbean.get(i).getDoctorName()%>>
				</form>

<%@ include file="../html/closeContent.html" %>


<%@ include file="../html/Footer.html" %>

</body>
</html>