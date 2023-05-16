<html>
<head>
<title>Login</title>
</head>
<body style="background-color:skyblue;">

<%
String msg=(String)request.getAttribute("msg");

if(msg!=null)
{
%>
	<h2><font color="red"><%= msg %></font></h2>	
<%}

%>


<form action="/CakeShop/userloginController" style="margin-top:200px; margin-left:400px;">
<pre>
<h2>
EMAILID   : <input type="text" name="emailid" required="required" autofocus="autofocus">

PASSWORD  : <input type="text" name="password" required="required">

            <input type="submit" value="login" style="height:40px; width:100px; border-radius:20px; background-color:gray; color:red; font-size:20px">   <a href='/Home.jsp'>Home</a>
</h2>

</pre>
</form>
</body>
</html>