<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.kk.app.DAO.OrderBookDAO"%>
<%@page import="java.util.Random"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.kk.app.DAO.CartDAO"%>
<%@page import="com.kk.app.DAO.CakeuserDAO"%>
<%@page import="com.kk.app.DTO.userdto"%>
<%@page import="com.kk.app.DTO.Cakeuserdto"%>
<%@page import="com.kk.app.DTO.CakeDTO"%>
<%@page import="com.kk.app.DTO.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>cartDisplayAll</title>
</head>
<style>

body
{

}
.btn
{
background-color: blue;
font-size: 20px;
color:white;
border-radius: 7px;
}


#remove
{
text-decoration:none;
color:blue;
font-size:18px;
font-weight: bolder;
align-items: right;
background: transparent;
}

#cancel
{
border:3px solid black;
background-color: red;
font-size: 20px;
border-radius: 7px;
text-decoration:none;
color:white;
font-size:20px;
font-weight: bolder;
padding: 1px;
}



#table 
{
background-color:white;
font-size:15px;
width:690px;
margin-left:250px;
margin-top:50px;
border:2px solid black;
box-shadow: 20px 35px 15px #888888;
}

tr,td
{
border:1px solid black;

}

th
{
border:1px solid black;
font-weight: bolder;
font-size:20px;
}

</style>
<body>

<%

List<CartDTO> cakes=(List<CartDTO>)request.getAttribute("cakes");

List<CartDTO> totalamt=(List<CartDTO>)request.getAttribute("totalamt");

CartDAO dao=new CartDAO();

String email=(String)session.getAttribute("emailid");
System.out.println(email);
userdto dto=(userdto)dao.search(email);

OrderBookDAO  dao1=new OrderBookDAO();

int orderno=0;
int count=1;
while(count>0)
{
String otp= new DecimalFormat("000").format(new Random().nextInt(999));
int order=Integer.parseInt(otp);

if(dao1.checkorderno(order))
{
	count++;
}
else
{
	orderno=order;
	count=0;
	System.out.println(order+" orderno");
}

}





%>


<table id="table">
<tr>
<th>Cake Name</th>
<th>1 Pcs Price</th>
<th>Quantity</th>
<th>Total</th>
<th>******</th>
</tr>
<%

if(cakes!=null)
{
	for(CartDTO cake:cakes)
	{
		%>
 		<tr>
		<td><%=cake.getCakename() %></td>
		<td style="text-align: right;"><%=cake.getPrice() %></td>
		<td style="text-align: center;"><%= cake.getCartcount() %></td>
		<td style="text-align: right;"><%= cake.getAddtotal() %></td>
		<td>
		<form action="/CakeShop/CartRemoveItemController" style="width:20px;">
			<input type="text" name="id" value="<%=cake.getId() %>" hidden="hidden">
			<input type="text" name="name" value="<%=cake.getCakename() %>" hidden="hidden">
			<input type="text" name="price" value="<%=cake.getPrice() %>" hidden="hidden">
			<input type="text" name="quantity" value="<%=cake.getQuantity() %>" hidden="hidden">
			<input type="submit" value="Remove" id="remove">
		</form>
		</td>
		</tr>
	<%
	System.out.println(cake.getId());
	}
	
	double total=0;
	for(CartDTO cake:totalamt)
	{
	
		double price=cake.getPrice();
		total=total+price;
	}
	
	%>
	
	<tr>
	<td  style="text-align: center; font-size:20px;"><b>Bill Amount</b></td>
	<td colspan="3" style="text-align: right; font-size:20px;" > <b><%=total%></b></td>
	<form action="/CakeShop/orderController">
	<input type="text" name="total" value="<%= total %>" hidden="hidden">
	</tr>
	<tr>
	<td>Enter Address</td>
	<td colspan="3"><textarea rows="3" cols="30" name="address" required="required" autofocus="autofocus"></textarea></td>
	</tr>
	<tr>
	<td colspan="4" style="text-align: center; font-size:20px;"><b>Payment</b></td>
	</tr>
	<tr>
	<td colspan="4" style="text-align: center; font-size:30px;"><b><i class="fa fa-cc-paypal" style="color:red"></i><i class="fa fa-cc-visa" style="color:blue; padding-left: 5px;"></i></b></td>
	</tr>
	<tr>
	<td colspan="4" style="text-align: center;"> <input type="submit" value="Pay" class="btn"> <a href="/CakeShop/CartBackController" id="cancel">Back</a></td>         
	</tr>
	<input type="text" name="orderno" value="<%= orderno %>" hidden="hidden">
	<input type="text" name="email" value="<%=dto.getEmail() %>" hidden="hidden">
	<input type="text" name="password" value="<%=dto.getPassword() %>" hidden="hidden">
	<input type="text" name="contactno" value="<%=dto.getContactno() %>" hidden="hidden">
	<input type="text" name="username" value="<%=dto.getName() %>" hidden="hidden">
	<%
	
}
%>

</table>
</form>
</body>
</html>