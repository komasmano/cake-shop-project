<%@page import="com.kk.app.DTO.CakeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

List<CakeDTO> cakes=(List<CakeDTO>)request.getAttribute("cakes"); 


%>


<table>
<tr>
<th>id</th>
<th>Cake Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>
<% 
if(cakes!=null)
{
	for(CakeDTO cake:cakes)
	{
		%>
		<tr>
		<td><%=cake.getId() %></td>
		<td><%=cake.getCakename() %></td>
		<td><%=cake.getPrice() %></td>
		<td><%=cake.getQuantity() %></td>
		</tr>
		<%
	}
}
%>

</table>


</body>
</html>