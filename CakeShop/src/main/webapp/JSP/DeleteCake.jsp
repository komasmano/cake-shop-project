<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<style>


#click
{
background-color:rgb(238,25,43);
font-size: 17px;
font-weight: bold;
color:white;
border-radius: 10px;
height: 30px;
}

#bookbtn4
{
background-color:rgb(150,60,43);
font-size: 17px;
font-weight: bold;
color:white;
border-radius: 10px;
height: 30px;
width:90px;
}

</style>


<%

String msg=(String)request.getAttribute("msg");

if(msg!=null)
{
	if(msg.contains("deleted"))
	{%>
		<h2><font color="green"><%=msg %></font></h2>
	<% }
	else
	{%>
		<h2><font color="red"><%=msg %></font></h2>
	<%}
}
%>


<h2 style="margin-top:40px; margin-left:460px;">Delete Cake</h2>
<form action="/CakeShop/deletecakeController" style="margin-top:10px; margin-left:400px;">
<pre> 
<h2>
ENTER CAKE ID : <input type="text" name="id" required="required" autofocus="autofocus">
</h2>                <input id="click" type="submit" value="Delete Entry"> <a href="/CakeShop/JSP/Admin.jsp"><button type="button" id="bookbtn4">Home</button></a>

</pre>
</form>


</body>
</html>