<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link href="../html/css.css" rel="stylesheet" type="text/css" />
<link href="../css/registration.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../JavaScript/Registration.js"></script>
<!-- Date Script  -->

<link type="text/css" href="../demoengine/demoengine.css" rel="stylesheet">
	<script type="text/javascript" src="../demoengine/demoengine.js" async defer></script>

	<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/ui-

darkness/jquery-ui.css" rel="stylesheet">
	<script type="text/javascript" 

src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" 

src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>





</head>
<body>
<%@ include file="../JSP Pages/Header.jsp" %>
<%@ include file="../html/content.html" %>
<table width="100%" height=100% border="1">
	<p><strong>Note: Items marked * are required fields</p>
	<form action="<%=request.getContextPath()%>/RegistrationController" name= "PatientForm" method="post" >
	
	
	
	<input type="radio" class="radio" name="UserType" value="Patient" checked="checked" onclick="location.href='../JSP Pages/PatientRegistration.jsp?registration=true'">Patient Registration</input>
	<input type="radio" class="radio" name="UserType" value="Doctor" onclick="location.href='../JSP Pages/DoctorRegistration.jsp?registration=true'">Doctor Registration</input>
	
				<fieldset id="personal">
					<legend><span>Personal Details</span></legend>
					<ol>
						<li><label class="Registrationlabel"  class="Registrationlabelrequired">First Name<span>*</span></label>
							<input class="Registrationinput" name="FirstName" maxlength="10" type="text" id="firstname" onblur="firstName();" />
							<q id="firstnameerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
								
						</li>
						<li>
							<label class="Registrationlabel" class="Registrationlabelrequired">Last Name<span>*</span></label>	
							<input class="Registrationinput" type="text" id="lastname" name="LastName" onblur="Lastname();"/>
							<q id="lastnameerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						<li>
							<label class="Registrationlabel" class="Registrationlabelrequired">Date of Birth<span>*</span></label>
							<input class="Registrationinput" type="text" id="datepicker" name="Date" />
						</li>
				
					</ol>
				</fieldset>
				<fieldset>
					<legend><span>Address Details</span></legend>
					<ol>
						<li>
							<label class="Registrationlabel" class="Registrationlabelrequired">House Number &amp; Street<span>*</span></label>
							<input class="Registrationinput" type="text" id="address1" name="Address1" onblur="House();" />
							<q id="houseerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						
						<li>
							<label class="Registrationlabel"  class="Registrationlabelrequired">Town/City<span>*</span></label>
							<input class="Registrationinput" type="text" id="address2" name="Address3" onblur="City();"/>
							<q id="cityerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						
						<li>
							<label class="Registrationlabel"  class="Registrationlabelrequired">Pincode<span>*</span></label>
							<input class="Registrationinput" type="text" id="pincode" name="PostCode" maxlength="6" onblur="Pincode();" />
							<q id="pincodeerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						<li>
							<label class="Registrationlabel" ">District</label>
							<input class="Registrationinput" type="text" id="address3" name="Address2" onblur="District();" />
							<q id="districterror" style="visibility:hidden;"><font size="2" color="red"></font></q>
							
						</li>
						<li>
							<label class="Registrationlabel"  class="Registrationlabelrequired">Country<span>*</span></label>
							<input class="Registrationinput" type="text" id="address4" name="Country" onblur="Country();"/>
							<q id="countryerror" style="visibility:hidden;"><font size="2" color="red"></font></q>	
						</li>
						<li>
							<label class="Registrationlabel">Mobile No</label>
							<input class="Registrationinput" type="text" id="phone" name="Phone" maxlength="10" onblur="Mobile();" />
							<q id="mobileerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
					</ol>
				</fieldset>
				<fieldset>
					<legend><span>Account Details</span></legend>
					<ol>
						<li>
							<label class="Registrationlabel"   class="Registrationlabelrequired">Email id<span>*</span></label>
							<input class="Registrationinput" type="text" id="emailid" name="EmailID" onblur="Emailvalidation();" />
							<q id="emailerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						<li>
							<label class="Registrationlabel"  class="Registrationlabelrequired">Verify Email id<span>*</span></label>
							<input class="Registrationinput" id="vemailid" name="VEmailID" onblur="Emailvalidation1();"/>
							<q id="vemailerror" style="visibility:hidden;"><font size="2" color="red"></font></q>
						</li>
						
					</ol>
				</fieldset>
				<fieldset >
					<input class="Registrationinput" type="button" value="Create Account"  onclick="createPatientAccount();"/>
					<input class="Registrationinput" type="button"  value="Reset" onclick="PatientReset();" />
					</label>
				</fieldset>
			</form>
						<script type="text/javascript">
		/*
		 * jQuery UI Datepicker: Parse and Format Dates
		 * http://salman-w.blogspot.com/2013/01/jquery-ui-datepicker-examples.html
		 */
		$(function() {
			$("#datepicker").datepicker({
				dateFormat: "dd-mm-yy",
				onSelect: function(dateText, inst) {
					var date = $.datepicker.parseDate(inst.settings.dateFormat || 

$.datepicker._defaults.dateFormat, dateText, inst.settings);
					var dateText1 = $.datepicker.formatDate("D, d M yy", date, 

inst.settings);
					date.setDate(date.getDate() + 7);
					var dateText2 = $.datepicker.formatDate("D, d M yy", date, 

inst.settings);
					
				}
			});
		});
	</script>
		</div>
		</div>
</table>
<%@ include file="../html/closeContent.html" %>
<%@ include file="../html/Footer.html" %>

</body>
</html>