<%@page import="com.kk.app.DTO.Cakeuserdto"%>
<%@page import="java.util.List"%>
<%@page import="com.kk.app.DTO.CakeDTO"%>
<%@page import="com.kk.app.DAO.CakeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cakeView</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
#nav_bar
 {
position: sticky;
  top: 0;
  left: 0;
  width: cover;
  height: 42px;
  padding-left: 10px;
  color: aqua;
  background-color: gray;
}

.btn
{
font-size: 25px;
font-family:cursive;
background-color: none;
border:3px solid red;
border-radius: 10px;
}


#quit
{
font-size: 25px;
font-family:cursive;
background-color: blue;
border:3px solid black;
border-radius: 10px;

}


.btn:hover
{
background-color: blue;
color:white;

}


#cake
{
margin-top: 3%;
opacity: 1.0;
}



#btn1
{
width:25px;
height: 35px;
font-size: 30px;
caret-color:red;
border:3px solid green;
border-radius: 6px;
background-color: black;
color:white;
}


#div1
{
position: absolute;
}


#div2
{
position: absolute;
padding-left: 1067px;
}

#div3
{
position: absolute;
padding-left: 970px;
}


#div4
{
position: absolute;
padding-left: 120px;
}

#image:hover
{
transform: scale(1.1);
transition: 1s;
transition-timing-function: ease;
}

#change:hover
{
transform: skew(10deg);

}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}




#profileform
{
position: absolute;
padding: 10px;
width: 350px;
height: 450px;
left:2% ;
top:2% ;
border-radius: 20px;
background:white;
display:none;
}


#message
{
position: absolute;
padding: 10px;
font-size:30px;
width: 300px;
height: 50px;
left:40% ;
top:2% ;
border-radius: 20px;
background:transparent;
color:red;
display:none;
}




</style>


<script type="text/javascript">

function updateopen()
{
 var form=document.getElementById("profileform");
 form.style.display="block";
  
}

function cancel()
{
 var form=document.getElementById("profileform");
 form.style.display="none"; 

 var fm=document.getElementById("cake");
 fm.style.opacity="1.0";
}

function quit()
{
 var form=document.getElementById("message");
 form.style.display="none"; 
 
 var fm=document.getElementById("cake");
 fm.style.opacity="1.0";
}
</script>


<body>
<% 
String show="0";
String count=(String)request.getAttribute("count");
if(count!=null)
{
     show=count;
}
%>

<div id="nav_bar">
<div id=div2>
<input type="text" value="<%=show %>" id="btn1" readonly="readonly" >
</div>

<div id=div3>

<form action="/CakeShop/cartDisplayAllController">
<input type="submit" value="CART" class="btn">
<input type="text" name="show" value="<%= show %>" hidden="hidden">
</form>
</div>

<div id=div4>
<form action="/CakeShop/userlogoutController">
<input type="submit" value="Logout" class="btn">
</form>
</div>


<div id=div1>
<form action="/CakeShop/selectProfileController">
<input type="submit" onclick="bg()" value="Profile" class="btn">
</form>
</div>
</div>

<% 
String methds=(String)request.getAttribute("methds");
System.out.println( methds + "message");
%>
<div id="message" Style="display:<%=methds%>;">
Add to cart...!!!<button type="button" id="quit" onclick="quit()">Cancel</button>
</div>



<%
String opacity=(String)request.getAttribute("opacity");
%>
<div id="cake" style="opacity:<%=opacity%>;">
<%
CakeDAO dao=new CakeDAO();
List<CakeDTO> dto=dao.DisplayAll();
%>

<container style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr; grid-template-rows: 350px 350px; gap:25px;">
		<% 
		for(CakeDTO dto1:dto)
		{
%>
<div id="gird">
			<img id="image" src="http://localhost:8085/CakeShop/Image/<%=dto1.getCakename() %>.jpg" alt="noimage" style="height:220px; width:250px;">
            <h3>
			<%=dto1.getCakename() %><br>
			Rs <%=dto1.getPrice() %><br>
			</h3>
			<form action="/CakeShop/AddCartController" style='margin-left:150px;'>
			<input type="text" name="id" value="<%=dto1.getId() %>" hidden="hidden">
			<input type="text" name="name" value="<%=dto1.getCakename() %>" hidden="hidden">
			<input type="text" name="price" value="<%=dto1.getPrice() %>" hidden="hidden">
			<input type="text" name="quantity" value="<%=dto1.getQuantity() %>" hidden="hidden">
			<input id="change" type="submit" value="Add cart"  style="height:40px; width:100px; border-radius:45px; background-color:green; color:white; font-size:20px; font-weight: bolder;">
			</form>
			</div>
	<%}%>
</container>
</div>




<% 
String method=(String)request.getAttribute("method");
%>
<div id="profileform" Style="display:<%=method%>;">
<%
Cakeuserdto prof=(Cakeuserdto)request.getAttribute("dto");
%>
<form action="/CakeShop/UpdateProfileController" style="margin-top:40px; margin-left:60px;">
<h2><pre>
     <i class="fa fa-user-circle" style="font-size:30px;color:blue; padding-right: 20px;"></i>Profile

   EMAILID 
   <input type="text"  value="<%=prof.getEmail() %>" name="emailid" required="required" readonly="readonly">

   PASSWORD
   <input type="text"  value="<%=prof.getPassword() %>" name="password" required="required" autofocus="autofocus">

   CONTACTNO
   <input type="number" value="<%=prof.getContactno() %>" name="contactno" required="required">

   NAME
   <input type="text" value="<%=prof.getName() %>" name="name" required="required">

 <input type="submit" value="update" class="btn" onclick="click()"> <button type="button" class="btn" onclick="cancel()">Cancel</button>
</pre>
</h2>         
</form>
</div>


</body>
</html>