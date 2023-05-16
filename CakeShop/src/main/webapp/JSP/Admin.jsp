<%@page import="com.kk.app.DTO.OrderBookDTO"%>
<%@page import="com.kk.app.DTO.Cakeuserdto"%>
<%@page import="com.kk.app.DTO.CakeDTO"%>
<%@page import="java.util.List"%>
<html>
<body>
<style>

#outer
{
position: relative;
width: 1110px;
height: 500px;
padding: 20px;

}


#div1
{
position:absolute;

width: 300px;
height: 500px;
}

#div2
{
position:absolute;
width: 800px;
height: 500px;
left:340px;
}

a
{
text-decoration: none;
font-family: cursive;
padding-left: 30px;
font-size: 30px;
font-weight: bolder;
}

a:hover
{
color:red;
}

table
{
border: 2px solid black;
text-align: center;
width: 800px;
}

td,th
{
border: 1px solid black;
text-align: center;
}

th
{
font-weight: bolder;
font-size: 17px;

}

</style>


<form action="/CakeShop/JSP/Home.jsp" style="margin-top:10px;">
<input type="submit" value="Logout" style="height:40px; width:150px; border-radius:10px; background-color:green; color:red; font-size:30px">
</form>
<div id="outer">
<div id="div1">
<p><a href="/CakeShop/cakeDisplayAllController">DisplayAll</a></p>
<p><a href="/CakeShop/JSP/AddCake.jsp">Insert</a></p>
<p><a href="/CakeShop/JSP/DeleteCake.jsp">Delete</a></p>
<p><a href="/CakeShop/JSP/SearchCake.jsp">Search</a></p>
<p><a href="/CakeShop/JSP/UpdateCake.jsp">Update</a></p>
<br>
<p><a style="color:red;" href="/CakeShop/userDisplayAll">Users</a></p>
<p><a style="color:red;" href="/CakeShop/DisplayAllorders">Orders</a></p>

</div>
<div id="div2">

<%

List<CakeDTO> cakes=(List<CakeDTO>)request.getAttribute("cakes"); 


if(cakes!=null)
{
%>

<table>
<tr>
<th>id</th>
<th>Cake Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>
<% 
	for(CakeDTO cake:cakes)
	{
		%>
		<tr>
		<td><%=cake.getId() %></td>
		<td style="text-align: left;"><%=cake.getCakename() %></td>
		<td><%=cake.getPrice() %></td>
		<td><%=cake.getQuantity() %></td>
		</tr>
		<%
	}
}
%>

</table>


</div>

<div id="div2">

<%

List<Cakeuserdto> users=(List<Cakeuserdto>)request.getAttribute("users"); 


if(users!=null)
{
%>

<table>
<tr>
<th>Mail Id</th>
<th>Name</th>
<th>Contact No</th>
</tr>
<% 
	for(Cakeuserdto user:users)
	{
		%>
		<tr>
		<td style="text-align: left;"><%=user.getEmail() %></td>
		<td style="text-align: left;"><%=user.getName() %></td>
		<td style="text-align: left;"><%=user.getContactno() %></td>
		</tr>
		<%
	}
}
%>

</table>


</div>




<div id="div2">

<%

List<OrderBookDTO> orders=(List<OrderBookDTO>)request.getAttribute("orders"); 


if(orders!=null)
{
%>

<table style="font-size: ">
<tr>
<th>Cake Id</th>
<th>Cake Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Total</th>
<th>Order No</th>
<th>UserName</th>
<th>Contact No</th>
<th>Address</th>
<th>Date</th>
<th>Time</th>
</tr>
<tr>

<%
int number=0;
	for(OrderBookDTO order:orders)
	{
		if(order.getCakename()!=null)
		{
		%>
		<td style="text-align: left;"><%= order.getId() %></td>
		<td style="text-align: left;"><%= order.getCakename() %></td>
		<td style="text-align: left;"><%= order.getPrice() %></td>
		<td style="text-align: left;"><%= order.getQuantity() %></td>
		<td style="text-align: left;"><%= order.getAddamount() %></td>
		<td style="text-align: left;"><%= order.getOrderno() %></td>
		<%
		
		}
		else
		{
			int add=1;
			number=number+add;
			%>
			<td><b><%=number%></b></td>
			<td><b>***</b></td>
			<td><b>***</b></td>
			<td><b>***</b></td>
		    <td style="text-align: left;"><b><%= order.getAddamount() %></b></td>
		    <td style="text-align: left;"><b><%= order.getOrderno() %></b></td>	
			<td style="text-align: left;"><b><%= order.getUsername() %></b></td>
			<td style="text-align: left;"><b><%= order.getContactno() %></b></td>
			<td style="text-align: left;"><b><%= order.getAddress() %></b></td>
			<td style="text-align: left;"><b><%= order.getDate() %></b></td>
			<td style="text-align: left;"><b><%= order.getTime() %></b></td>
			</tr>
		<tr>
		<td colspan="11" style="background-color:black "></td>
		<% 		}
		%>

		
		</tr>
		<%
	}
}
%>

</table>


</div>




</div>
<script>
<include src="JSP/CakeDisplayAll.jsp"></include>
      let includes = document.getElementsByTagName('include');
      for (var i = 0; i < includes.length; i++) {
         let include = includes[i];
         load_file(includes[i].attributes.src.value, function(text) {
            include.insertAdjacentHTML('afterend', text);
            include.remove();
         });
      }
      function load_file(filename, callback) {
         fetch(filename).then(response => response.text()).then(text => callback(text));
      }
   </script>

</body>
</html>