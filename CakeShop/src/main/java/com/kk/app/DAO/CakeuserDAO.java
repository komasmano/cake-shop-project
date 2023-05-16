package com.kk.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kk.app.DBUtility.CakeShopDBUtility;
import com.kk.app.DTO.Cakeuserdto;

public class CakeuserDAO 
{
	
	

	public boolean Registration(Cakeuserdto dto)
	{
		
		boolean res=true;
		
		Connection con=CakeShopDBUtility.getConnection();
		
		try
		{
			PreparedStatement pstmt=con.prepareStatement("insert into user values(?,?,?,?)");
			
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setLong(3, dto.getContactno());
			pstmt.setString(4, dto.getName());
		
			int nori=pstmt.executeUpdate();
			
			if(nori!=1)
			{
				res=false;
			}
			} 
		catch (SQLException e) 
		{
			res=false;
			e.printStackTrace();
		}
		
		CakeShopDBUtility.closeConnection(con);
		return res;
	}




public boolean login(Cakeuserdto dto)
{
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
	PreparedStatement pstmt=con.prepareStatement("select emailid, password from user where emailid=? and password=?");
	pstmt.setString(1, dto.getEmail());
	pstmt.setString(2, dto.getPassword());
	ResultSet rs=pstmt.executeQuery();
	
	if(rs.next()==false)
	{
		res=false;
	}
	}
	catch (SQLException e) 
	{	
	e.printStackTrace();
	res=false;
	}
	CakeShopDBUtility.closeConnection(con);
	return res;
}

public boolean userPresent(Cakeuserdto dto)
{
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
	PreparedStatement pstmt=con.prepareStatement("select emailid from user where emailid=?");
	pstmt.setString(1, dto.getEmail());
	ResultSet rs=pstmt.executeQuery();
	
	if(rs.next()==false)
	{
		res=false;
	}
	}
	catch (SQLException e) 
	{	
	e.printStackTrace();
	res=false;
	}
	CakeShopDBUtility.closeConnection(con);
	return res;
}



public Cakeuserdto selectProfille(String email)
{
	Cakeuserdto dto=null;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
	PreparedStatement pstmt=con.prepareStatement("select * from user where emailid=?");
	pstmt.setString(1, email);
	
	ResultSet rs=pstmt.executeQuery();

	if(rs.next())
	{
		dto=new Cakeuserdto();
		dto.setEmail(rs.getString(1));
		dto.setPassword(rs.getString(2));
		dto.setContactno(rs.getLong(3));
		dto.setName(rs.getString(4));
	}
	}
	catch (SQLException e) 
	{	
	e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return dto;
}




public List<Cakeuserdto> DisplayAlluser()
{
	
	List<Cakeuserdto> user=new ArrayList<Cakeuserdto>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
	PreparedStatement pstmt=con.prepareStatement("select * from user");
	ResultSet rs=pstmt.executeQuery();

	while(rs.next())
	{
	Cakeuserdto dto=new Cakeuserdto();
	
	dto.setEmail(rs.getString(1));
	dto.setPassword(rs.getString(2));
	dto.setContactno(rs.getLong(3));
	dto.setName(rs.getString(4));
	user.add(dto);
		
	}
	}
	catch (SQLException e) 
	{	
	e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return user;
}







public boolean updateProfile(Cakeuserdto dto)
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("update user set password=?, contactno=?, name=? where emailid=?");		
		pstmt.setString(1, dto.getPassword());
		pstmt.setLong(2, dto.getContactno());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getEmail());
		
		int nori=pstmt.executeUpdate();
		
		if(nori!=1)
		{
			res=false;
		}
		} 
	catch (SQLException e) 
	{
		res=false;
		e.printStackTrace();
	}
	
	CakeShopDBUtility.closeConnection(con);
	return res;
}


public static char[] captcha()
{
	String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String Small_chars = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    
    String values = Capital_chars + Small_chars + numbers;
   
    Random rndm_method = new Random();
            
    char[] len=new char[6];
    
    for(int i=0; i<len.length; i++)
    {
    	len[i]=values.charAt(rndm_method.nextInt(values.length()));
    }
    
 return  len;
}




}