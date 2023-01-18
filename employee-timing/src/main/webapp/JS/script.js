function makeActive(linkid)
{
	document.getElementById(linkid).style.color="red";
}
function makeActive1(linkid)
{
	document.getElementById(linkid).style.backgroundColor="blue";
}
function checkEmptyField()
{
	st=true;
	var t1=document.getElementById("cid");
	var t2=document.getElementById("firstname");
	var t3=document.getElementById("lastname");
	var t4=document.getElementById("address");
	var t5=document.getElementById("phone");
	var t6=document.getElementById("emailid");
	document.getElementById("e1").innerHTML="";
	document.getElementById("e2").innerHTML="";
	document.getElementById("e3").innerHTML="";
	document.getElementById("e4").innerHTML="";
	document.getElementById("e5").innerHTML="";
	document.getElementById("e6").innerHTML="";
	if(t1.value=="")
	{
		document.getElementById("e1").innerHTML="Customer id is required";
		st=false;
	}
	if(t2.value=="")
	{
		document.getElementById("e2").innerHTML="First name is required";
		st=false;
	}
	if(t3.value=="")
	{
		document.getElementById("e3").innerHTML="Last name is required";
		st=false;
	}
	if(t4.value=="")
	{
		document.getElementById("e4").innerHTML="Address is required";
		st=false;
	}
	if(t5.value=="")
	{
		document.getElementById("e5").innerHTML="Phone number is required";
		st=false;
	}
	if(t6.value=="")
	{
		document.getElementById("e6").innerHTML="Email id is required";
		st=false;
	}
	return st;
}