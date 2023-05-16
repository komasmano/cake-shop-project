<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body style="background-color:skyblue;">

<%
String msg=(String)request.getAttribute("msgs");

if(msg!=null)
{
	if(msg.contains("completed"))
	{%>
	<h2><font color="green"><%= msg %></font></h2>
	<%	
	}
	else
    {%>
	<h2><font color="green"><%= msg %></font></h2>
	<%	
	}	
}

%>

<form action="/CakeShop/userRegistrstionController" style="margin-top:200px; margin-left:400px;">
<h2>
<pre>
EMAILID   : <input type="text" name="emailid" required="required" autofocus="autofocus">

PASSWORD  : <input type="text" name="password" required="required">

CONTACTNO : <input type="text" name="contactno" required="required">

NAME      : <input type="text" name="name" required="required">

    
            <input type="submit" value="Registration" style="height:50px; width:200px; border-radius:20px; background-color:gray; color:red; font-size:20px">
</h2>
</

pre>         
</form>
</body>
</html>