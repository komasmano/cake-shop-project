<%@page import="java.util.List"%>
<%@page import="com.kk.app.DTO.OrderBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Placed</title>
</head>

<style>
#btn1
{
width:50px;
height: 35px;
font-size: 30px;
caret-color:red;
border:3px solid black ;
border-radius: 6px;
background-color:maroon;
color:white;

}

#btn1:hover
{
opacity: 0.7;

}

a
{
text-decoration: none;

}

th,td,tr
{
padding:5px;
}



</style>
<body>
<% 

List<OrderBookDTO> orders=(List<OrderBookDTO>)request.getAttribute("orders");

List<OrderBookDTO> totalamt=(List<OrderBookDTO>)request.getAttribute("totalamt");

String name=(String)request.getAttribute("name");

String username=name.toUpperCase();

String contactno=request.getParameter("contactno");

int orderno=Integer.parseInt(request.getParameter("orderno"));
double totamt=0;
%>
<h2><font color="red"> Hi <%= username %> </font></h2>
<h4><font color="red"> Contact No : <%= contactno  %> </font></h4>
<h2><font color="green"> Your Order Placed..!!!</font></h2>

<h3><font color="blue"> Your order number : <%= orderno %> </font></h3>
<table>
<tr>
<th>SNo</th>
<th>Items</th>
<th>1 Pcs</th>
<th>Quantity</th>
<th>Amount</th>
</tr>

<% 
int number=0;
for(OrderBookDTO order:orders)	
{
    String cakename=order.getCakename();
    double price=order.getPrice();
    String quantity=order.getQuantity();
    double amount=order.getAddamount();
    int add=1;
    number=number+add;
%>


<tr>
<td><%= number %></td>
<td style="text-align:left;"><%= cakename %></td>
<td style="text-align:right;"><%= price %></td>
<td style="text-align:center;"><%= quantity %></td>
<td style="text-align:right;"><%= amount %></td>
</tr>
<tr>
<%
}
for(OrderBookDTO amt:totalamt)
{

totamt=amt.getAddamount();
}
%>
<td colspan="4" style="text-align:right;"><b>Total</b></td>
<td style="text-align:right;"><b><%= totamt %></b></td>
</tr>
</table><br>
<a id="btn1" href="JSP/CakeView.jsp">Home</a>
</body>
</html>