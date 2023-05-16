<%@page import="com.kk.app.DTO.CakeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
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

<h2 style="margin-top:40px; margin-left:460px;">Search Cake</h2>
<form action="/CakeShop/searchcakeController" style="margin-top:10px; margin-left:400px;">
<pre> 
<h2>
ENTER CAKE ID : <input type="text" name="id" required="required" autofocus="autofocus">
                <input type="text" name="option" value="update" hidden="hidden">  
</h2>               <input id="click" type="submit" value="Search">  <a href="/CakeShop/JSP/Admin.jsp"><button type="button" id="bookbtn4">Home</button></a>
</pre>
</form>

<%
String msg=(String)request.getAttribute("msg");

if(msg!=null)
{%>
	<h2><font color="red"><%=msg %></font></h2>
<%
}
%>

<%
CakeDTO dto=(CakeDTO)request.getAttribute("cakes");  

if(dto!=null)
{
%>

<h2 style="margin-left:30px;">update Student</h2>
<form action="/CakeShop/updatecakeController" style="margin-top:10px;">
<pre> 
<h2>
ID         : <input type="text" name="id" value="<%=dto.getId() %>" readonly="readonly">

CAKE NAME  : <input type="text" name="name" value="<%=dto.getCakename() %>" >

PRICE      : <input type="text" name="price" value="<%=dto.getPrice() %>">

QUANTITY   : <input type="text" name="quantity" value="<%=dto.getQuantity() %>">

         <input id="click" type="submit" value="update Entry" >
</h2>
</pre>
</form>
<%
}
%>

</body>
</html>