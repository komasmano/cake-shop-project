<html>
<head>
<title>Home</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>


<style>

#background-image
{
    background-image: url(http://localhost:8085/CakeShop/Image/Home.webp);
    width: 99%;
    height: 600px;
    background-size: cover;
    background-attachment: fixed;
    background-repeat: no-repeat;
    margin-top: 0px;
    position: relative;
}

a
{
text-decoration: none;
}
p
{
font-weight: bolder;
}

#loginform
{
position: absolute;
padding: 10px;
width: 350px;
height: 380px;
left:30% ;
top:20% ;
border-radius: 20px;
background: rgba(165, 243, 252, 0.3);
display:none;
}


#rgform
{
position: absolute;
padding: 10px;
width: 350px;
height: 350px;
left:30% ;
top:20% ;
border-radius: 20px;
background: rgba(255, 0, 0, 0.5);
display:none;
}


#bookbtn1
{
    position: absolute;
    left: 950px;
    top: 50px;
    width: 200px;
    height: 40px;
    font-size: 30px;
    border-radius: 10px;
    font-family:monospace;
    background: rgba(165, 243, 150, 0.3);
}

#bookbtn1:hover
{
 background: rgba(165, 243, 150, 1.0);
}



#bookbtn2
{
    position: absolute;
    left: 950px;
    top: 120px;
    width: 200px;
    height: 40px;
    font-size: 30px;
    border-radius: 10px;
    font-family:monospace;
     background: rgba(165, 243, 150, 0.3);
}

#bookbtn2:hover
{
 background: rgba(165, 243, 150, 1.0);
}


#bookbtna
{
    position: absolute;
    left: 20px;
    top: 50px;
    width: 200px;
    height: 40px;
    font-size: 30px;
    border-radius: 10px;
    font-family:monospace;
    background: rgba(165, 243, 150, 0.3);
}

#bookbtna:hover
{
 background: rgba(165, 243, 150, 1.0);
}

#font
{
position:absolute;
left:40% ;
top:40% ;
display:none;
}

#font1
{
position:absolute;
left:40% ;
top:30% ;
display:none;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

a
{
text-decoration: none;
}

</style>

<script type="text/javascript">

function logopen()
{
 var form=document.getElementById("loginform");
 form.style.display="block";
 
 var form=document.getElementById("font");
 form.style.display="block";

 var form=document.getElementById("rgform");
 form.style.display="none";

 
}

function submit()
{
 var form=document.getElementById("loginform");
 form.style.display="block"; 
}

function rgopen()
{
 var form=document.getElementById("rgform");
 form.style.display="block";
 
 var form=document.getElementById("font1");
 form.style.display="block";
 
 var form=document.getElementById("loginform");
 form.style.display="none";
 
}

function click()
{
 var form=document.getElementById("rg");
 form.style.display="block"; 
}



</script>


<body id="background-image">
<center>
<p style="color:red; font-family:cursive; font-size:80px;">Delicious Cakes </p>
<div>
<a href="/CakeShop/captchagencontroller"><button type="button" id="bookbtna" onclick="logopen()"><i class="fas fa-desktop" style="font-size:30px;color:red; padding-right: 20px;"></i>Admin</button></a>
<a href="/CakeShop/captchagencontroller"><button type="button" id="bookbtn1" onclick="logopen()"><i class="fa fa-user-circle" style="font-size:30px;color:blue; padding-right: 20px;"></i>Account</button></a>
<button type="button" id="bookbtn2" onclick="rgopen()"><i class="fa fa-user-plus" style="font-size:28px;color:red; padding-right: 10px;"></i>Register</button>
</div>
</center>
<center>
<%
String mtd1=(String)request.getAttribute("mtd");
%>
<i class="fa fa-spinner fa-pulse" id="font" style="font-size:120px;color:white; display:<%=mtd1%>;"></i>
<i class="fa fa-refresh fa-spin" id="font1" style="font-size:160px;color:green;"></i>
</center>
<%
String len=(String)request.getAttribute("cap");

String mtd=(String)request.getAttribute("mtd");


%>

<div id="loginform" Style="display:<%=mtd%>;">

<form action="/CakeShop/userloginController" style="margin-top:10px; margin-left:40px;">
<pre>
<h2>          Login

EMAILID  <input type="text" name="emailid" required="required" autofocus="autofocus">

PASSWORD <input type="text" name="password" required="required">

CAPTCHA  <font style="font-size: 25px;"> <%=len%></font> <input type="text" name="len" value="<%=len%>" hidden="hidden">

         <input type="text" name="captcha" required="required">
         
<button type="button" class="btn btn-secondary" id="bookbtn3" onclick="submit()" style="height:40px; width:100px; border-radius:20px; background-color:gray; color:red; font-size:20px">login</button>   <a href="http://localhost:8085/CakeShop/JSP/Home.jsp"><button type="button" id="bookbtn4" style="height:40px; width:100px; border-radius:20px; background-color:green; color:reen; font-size:20px">Back</button></a>
</h2>
</pre>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
%>
<h2><font color="red" ><%= msg %></font></h2>	
<%}%>
</form>
</div>


<%

String mailid=(String)request.getAttribute("emailid");

String pass=(String)request.getAttribute("password");

String len1=(String)request.getAttribute("caps");

String mtds=(String)request.getAttribute("mtds");
%> 

<div id="loginform" Style="display:<%=mtds%>;">

<form action="/CakeShop/userloginController" style="margin-top:10px; margin-left:40px;">
<pre>
<h2>          Login

EMAILID  <input type="text" name="emailid" required="required" value="<%=mailid%>">

PASSWORD <input type="text" name="password" required="required" value="<%=pass%>">

CAPTCHA  <font style="font-size: 25px;"> <%=len1%></font> <input type="text" name="len" value="<%=len1%>" hidden="hidden">

         <input type="text" name="captcha" required="required" autofocus="autofocus">
         
<button type="button" class="btn btn-secondary" id="bookbtn3" onclick="submit()" style="height:40px; width:100px; border-radius:20px; background-color:gray; color:red; font-size:20px">login</button>   <a href="http://localhost:8085/CakeShop/JSP/Home.jsp"><button type="button" id="bookbtn4" style="height:40px; width:100px; border-radius:20px; background-color:green; color:reen; font-size:20px">Back</button></a>
</h2>
</pre>
<%
String msg1=(String)request.getAttribute("msg1");
if(msg1!=null)
{
%>
<h2><font color="red" ><%= msg1 %></font></h2>	
<%}%>
</form>
</div>









<% 
String method=(String)request.getAttribute("method");
%>
<div id="rgform" Style="display:<%=method%>;">
<form action="/CakeShop/userRegistrstionController" style="margin-top:40px; margin-left:30px;">
<h2><pre>
EMAILID   : <input type="text" name="emailid" required="required" autofocus="autofocus">

PASSWORD  : <input type="text" name="password" required="required">

CONTACTNO : <input type="number" name="contactno" required="required">

NAME      : <input type="text" name="name" required="required">

    <input type="submit" value="Register" id="bookbtn3" onclick="click()" style="height:40px; width:100px; border-radius:20px; background-color:gray; color:lime; font-size:20px"> <a href="http://localhost:8085/CakeShop/JSP/Home.jsp"><button type="button" id="bookbtn4" style="height:40px; width:100px; border-radius:20px; background-color:green; color:reen; font-size:20px">Back</button></a>
</h2>
</pre>

<%
String msgs=(String)request.getAttribute("msgs");

if(msgs!=null)
{
	if(msgs.contains("completed"))
	{%>
	<h2><font color="black"><%= msgs %></font></h2>
	<%	
	}
	else
    {%>
	<h2><font color="white"><%= msgs %></font></h2>
	<%	
	}	
}%>         
</form>
</div>
</body>
</html>