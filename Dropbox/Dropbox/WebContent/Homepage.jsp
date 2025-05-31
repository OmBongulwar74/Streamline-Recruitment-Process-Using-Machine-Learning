<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BREA</title>
</head>
<body>
	<!-- script-for-nav -->
	<%@include file="Header.jsp"%>
	<div class="banner">
	<script>
						$( "span.menu" ).click(function() {
						  $( ".head-nav ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
						
					</script>
				<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<div class="banner-info">
										<h1><font color="#EAE8FF">Cloud computing</font></h1>
										<p><font color="#EAE8FF">Cloud computing is an information technology (IT) paradigm that enables ubiquitous access to shared pools of configurable system resources and higher-level services that can be rapidly provisioned with minimal management effort, often over the Internet.</font></p>	
									</div>
								</li>
								<li>
									<div class="banner-info">
										<h1><font color="#EAE8FF">Why Encryption?</font></h1>
										<p><font color="#EAE8FF">Encryption is widely used on the internet to protect user information being sent between a browser and a server, including passwords, payment information and other personal information that should be considered private. Organizations and individuals also commonly use encryption to protect sensitive data stored on computers, servers and mobile devices like phones or tablets.</font></p>	
									</div>
								</li>
								<li>	
									<div class="banner-info">
										<h1><font color="#EAE8FF">Cloud Security</font></h1>
										<p><font color="#EAE8FF">Cloud computing security or, more simply, cloud security refers to a broad set of policies, technologies, and controls deployed to protect data, applications, and the associated infrastructure of cloud computing. It is a sub-domain of computer security, network security, and, more broadly, information security.</font></p>	
									</div>
									<div class="clearfix"> </div>
								</li>
							</ul>
						</div>
					</section>
						<!-- FlexSlider -->
							  <script defer src="js/jquery.flexslider.js"></script>
							  <script type="text/javascript">
								$(function(){
								  SyntaxHighlighter.all();
								});
								$(window).load(function(){
								  $('.flexslider').flexslider({
									animation: "slide",
									start: function(slider){
									  $('body').removeClass('loading');
									}
								  });
								});
							  </script>
							  </div>
							  
							  
						<!-- FlexSlider -->
						<%@include file="Footer.jsp"%>
</body>
</html>