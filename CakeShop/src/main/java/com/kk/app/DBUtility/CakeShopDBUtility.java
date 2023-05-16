package com.kk.app.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CakeShopDBUtility 
{
	
static
{
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static Connection getConnection()
{
	
	Connection con=null;	
	try 
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeshop?user=root&password=komas");
	} 
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	return con;
}

public static void closeConnection(Connection con)
{
	
if(con!=null)	
{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
}

}

