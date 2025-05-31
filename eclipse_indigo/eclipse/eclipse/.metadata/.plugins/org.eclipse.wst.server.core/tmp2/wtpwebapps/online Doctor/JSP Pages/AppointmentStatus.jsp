<%@page import="bean.AppointmentDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Status</title>
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<link href="../html/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>
<fieldset id="personal">
					<legend><span>Appointment Status</span></legend>
					<ol>
					<%if(session!=null){
						int rowsUpdated=(Integer)session.getAttribute("rowsUpdated");
						AppointmentDetail appointmentBean=(AppointmentDetail)session.getAttribute("appointmentBean");
						if(rowsUpdated>0){%>
						
							<li><label  ><font size="4px"><b>Appointment Schedule</b></font></label></li>
							<li><label><font size="3px">Doctor Name: <%=appointmentBean.getDoctorName() %></font></label></li>
							<li><label><font size="3px">Appointment Start Date:<%=appointmentBean.getStartDate()%></font></label></li>
							<li><label><font size="3px">Appointment End Date:<%=appointmentBean.getEndDate()%></font></label></li>
							<li><label><font size="3px">Appointment Start Time:<%=appointmentBean.getStartTime()%></font></label></li>
							<li><label><font size="3px">Appointment End Time:<%=appointmentBean.getEndTime()%></font></label></li>
						
					<% 	
						}else{
							%>
							<li><label> <font size="3px">Appointment might be taken by somebody. Kindly select another time</font></label><li>
							
							<%
						}
					}	%>
					
						
						</li>
						</ol>
						
						</fieldset>
						
						<%@ include file="../html/closeContent.html" %>


<%@ include file="../html/Footer.html" %>

						 	
</body>
</html>