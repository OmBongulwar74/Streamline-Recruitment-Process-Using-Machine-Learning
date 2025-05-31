function firstName()
{
   var firstname=document.getElementById("firstname").value;
    firstname=firstname.trim();
    var invalidChar1="~!@#$%^&*()_+=-:{} ></[].,\"\'1234567890";
    if(firstname.length==0)
    {
	   document.getElementById("firstnameerror").innerHTML="First Name cannot be empty";
	   document.getElementById("firstnameerror").style="visibility:visible;color:red";
	   document.getElementById("firstname").value="";
	   return false;
    }  
	
	
  
	
	for(var i=0;i<firstname.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(firstname.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("firstnameerror").innerHTML="Only alphabets are allowed";
			       document.getElementById("firstnameerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
document.getElementById("firstname").value;

document.getElementById("firstnameerror").style="visibility:hidden";
return true;
}


function Lastname()
{	
	

	var lastname=document.getElementById("lastname").value;
                lastname=lastname.trim();

    var invalidChar2="~!@#$%^&*()_+=-:{} ></.,\"\'1234567890";
	
	if(lastname.length==0)
	{

		document.getElementById("lastnameerror").innerHTML="Last Name cannot be empty";
		document.getElementById("lastnameerror").style="visibility:visible;color:red";
		document.getElementById("lastname").value;
		return false;
	}
	for(var x=0;x<lastname.length;x++)
	{
		for(var y=0;y<invalidChar2.length;y++)
			{
			if(lastname.charAt(x)==invalidChar2.charAt(y))
              {
			      document.getElementById("lastnameerror").innerHTML="Only alphabets are allowed";
			      document.getElementById("lastnameerror").style="visibility:visible;color:red";
			
			      return false;
			   }
			
			}
	}
	document.getElementById("lastname").value;
	document.getElementById("lastnameerror").style="visibility:hidden";
	return true;
}

function Mobile()
{	
	

	var mobile=document.getElementById("phone").value;
                mobile=mobile.trim();

	var invalidChar4="~!@#$%^&*()_+=-:{} ></.,\\ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	if(mobile.length==0)
	{

		document.getElementById("mobileerror").innerHTML="Mobile No. cannot be empty";
		document.getElementById("mobileerror").style="visibility:visible;color:red";
		document.getElementById("phone").value;
		return false;
	}
	if(mobile.length<10)
	{

		document.getElementById("mobileerror").innerHTML="Mobile No. must be of 10 digits";
		document.getElementById("mobileerror").style="visibility:visible;color:red";
		document.getElementById("phone").value;
		return false;
	}
	for(var i=0;i<mobile.length;i++)
	{
		for(var j=0;j<invalidChar4.length;j++)
			{
			if(mobile.charAt(i)==invalidChar4.charAt(j))
              {
			       document.getElementById("mobileerror").innerHTML="Only Numbers are allowed";
			       document.getElementById("mobileerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
	document.getElementById("phone").value;
	document.getElementById("mobileerror").style="visibility:hidden";
	return true;
}


function Pincode()
{	
	var pincode=document.getElementById("pincode").value;
                pincode=pincode.trim();

	var invalidChar5="~!@#$%^&*()_+=-:{} ></.,\\ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	if(pincode.length==0)
	{

		document.getElementById("pincodeerror").innerHTML="Pincode cannot be empty";
		document.getElementById("pincodeerror").style="visibility:visible;color:red";
		document.getElementById("pincode").value;
		return false;
	}
	if(pincode.length<6)
	{

		document.getElementById("pincodeerror").innerHTML="Pincode must be of 6 digit";
		document.getElementById("pincodeerror").style="visibility:visible;color:red";
		document.getElementById("pincode").value;
		return false;
	}
	for(var i=0;i<pincode.length;i++)
	{
		for(var j=0;j<invalidChar5.length;j++)
			{
			if(pincode.charAt(i)==invalidChar5.charAt(j))
               {
			       document.getElementById("pincodeerror").innerHTML="Only Numbers are allowed";
			       document.getElementById("pincodeerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
	        }
    }
	document.getElementById("pincode").value;
	document.getElementById("pincodeerror").style="visibility:hidden";
	return true;
}
               
function District()
{
   var district=document.getElementById("address3").value;
       district=district.trim();
    
  var invalidChar1="~!@#$%^&*()_+=-:{} ></.,\"\'1234567890";
    if(district.length==0)
    {
	   document.getElementById("districterror").innerHTML=" District cannot be empty";
	   document.getElementById("districterror").style="visibility:visible;color:red";
	   document.getElementById("address3").value;
	   return false;
    }
	
	
  
	
	for(var i=0;i<district.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(district.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("districterror").innerHTML="Only alphabets are allowed";
			       document.getElementById("districterror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
   document.getElementById("address3").value;
   document.getElementById("districterror").style="visibility:hidden";
   return true;
}

function Country()
{
   var country=document.getElementById("address4").value;
       country=country.trim();
    
  var invalidChar1="~!@#$%^&*()_+=-:{} ></.,\"\'1234567890";
    if(country.length==0)
    {
	   document.getElementById("countryerror").innerHTML="Country cannot be empty";
	   document.getElementById("countryerror").style="visibility:visible;color:red";
	   document.getElementById("address4").value;
	   return false;
    }
	
	
  
	
	for(var i=0;i<country.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(country.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("countryerror").innerHTML="Only alphabets are allowed";
			       document.getElementById("countryerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
   document.getElementById("address4").value;
   document.getElementById("countryerror").style="visibility:hidden";
   return true;
}

function City()
{
   var city=document.getElementById("address2").value;
       city=city.trim();
    
  var invalidChar1="~!@#$%^&*()_+=-:{} ></.,\"\'1234567890";
    if(city.length==0)
    {
	   document.getElementById("cityerror").innerHTML="City cannot be empty";
	   document.getElementById("cityerror").style="visibility:visible;color:red";
	   document.getElementById("address2").value;
	   return false;
    }
	
	
  
	
	for(var i=0;i<city.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(city.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("cityerror").innerHTML="Only alphabets are allowed";
			       document.getElementById("cityerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
   document.getElementById("address2").value;
   document.getElementById("cityerror").style="visibility:hidden";
   return true;
}


function House()
{
   var house=document.getElementById("address1").value;
   house=house.trim();
    
  var invalidChar1="~!@#$%^&*+?<>{}[]|";
    if(house.length==0)
    {
	   document.getElementById("houseerror").innerHTML="Please enter your House No";
	   document.getElementById("houseerror").style="visibility:visible;color:red";
	   document.getElementById("address1").value;
	   return false;
    }
	
	
  
	
	for(var i=0;i<house.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(house.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("houseerror").innerHTML="Special symbols are not allowed";
			       document.getElementById("houseerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
    document.getElementById("address1").value;
    document.getElementById("houseerror").style="visibility:hidden";
    return true;
}

function License()
{
   var license=document.getElementById("licensenumber").value;
   license=license.trim();
    
  var invalidChar1="~!@#$%^&*+?<>{}[]|+=/\.,:_";
    if(license.length==0)
    {
	   document.getElementById("licenseerror").innerHTML="Please enter your License No";
	   document.getElementById("licenseerror").style="visibility:visible;color:red";
	   document.getElementById("licensenumber").value;
	   return false;
    }
	
	
  
	
	for(var i=0;i<license.length;i++)
	{
		for(var j=0;j<invalidChar1.length;j++)
			{
			if(license.charAt(i)==invalidChar1.charAt(j))
               {
			       document.getElementById("licenseerror").innerHTML="Special symbols are not allowed";
			       document.getElementById("licenseerror").style="visibility:visible;color:red";
			
			       return false;
			   }
			
			}
	}
     document.getElementById("licensenumber").value;
     document.getElementById("licenseerror").style="visibility:hidden";
     return true;
}
function Reset()
{
	document.getElementById("firstname").value="";
	document.getElementById("firstnameerror").style="visibility:hidden";
	document.getElementById("lastname").value="";
	document.getElementById("lastnameerror").style="visibility:hidden";
	document.getElementById("phone").value="";
	document.getElementById("mobileerror").style="visibility:hidden";
	document.getElementById("pincode").value="";
	document.getElementById("pincodeerror").style="visibility:hidden";
	document.getElementById("address3").value="";
	document.getElementById("districterror").style="visibility:hidden";
	document.getElementById("address2").value="";
	document.getElementById("cityerror").style="visibility:hidden";
	document.getElementById("address1").value="";
	document.getElementById("houseerror").style="visibility:hidden";
	document.getElementById("address4").value="";
	document.getElementById("countryerror").style="visibility:hidden";
	document.getElementById("licensenumber").value="";
	document.getElementById("licenseerror").style="visibility:hidden";
	
}


function checkDetails()
{
	if(firstName()==true || firstName()==true )
	 this.Form.submit();
	

}