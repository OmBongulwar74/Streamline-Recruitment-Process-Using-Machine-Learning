<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link href="../html/css.css" rel="stylesheet" type="text/css" />
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<%String password=(String)session.getAttribute("password");%>
<script type="text/javascript">

function checkPassword()
{

	if(checkoldpassword()==true)
		this.changepassword.submit();
	}


function checkoldpassword()
{
	var currentpassword=document.getElementById("opassword").value;
	var pass='<%=password%>';
	if(!(pass==currentpassword)){
		alert("Old Password is incorrect");
		return false;
	}
	return true;	
}


</script>
</head>
<body>
	<%@ include file="../JSP Pages/Header.jsp"%>
	<%@ include file="../html/content.html"%>
	
	<div style="float:right;width:100%;" >
	<form action="<%=request.getContextPath()%>/Controller?button=changepassword" name= "changepassword" method="post">
	<fieldset id="Password Change">
		<legend>
			<span>Password Change</span>
		</legend>
		<ol>
			<li><label class="Registrationlabel"
				class="Registrationlabelrequired">Old Password<span>*</span>
			</label> <input class="Registrationinput" name="OPassword" type="password"
				id="opassword" onblur="checkoldpassword();"/> 
			</li>
			<li><label class="Registrationlabel"
				class="Registrationlabelrequired">New Password<span>*</span>
			</label> <input class="Registrationinput" type="password" id="npassword"
				name="NPassword" /></li>
			<li><label class="Registrationlabel"
				class="Registrationlabelrequired">Confirm New Password<span>*</span>
			</label> <input class="Registrationinput" type="password" id="cnpassword"
				name="CNPassword" /></li>
<li>
				<input class="Registrationinput" type="button" id="submitpassword" value="Change Password"  onclick="checkPassword();"/>
	</li>
		</ol>
	</fieldset>
	</form>
</div>

	<%@ include file="../html/closeContent.html"%>


	<%@ include file="../html/Footer.html"%>
</body>
</html>