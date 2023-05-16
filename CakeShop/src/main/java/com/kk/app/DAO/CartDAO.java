package com.kk.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kk.app.DBUtility.CakeShopDBUtility;
import com.kk.app.DTO.CakeDTO;
import com.kk.app.DTO.Cakeuserdto;
import com.kk.app.DTO.CartDTO;
import com.kk.app.DTO.userdto;

public class CartDAO 
{

	
public boolean addcart(CartDTO dto)
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("insert into cart values(?,?,?,?)");
		pstmt.setInt(1, dto.getId());
		pstmt.setString(2, dto.getCakename());
		pstmt.setDouble(3, dto.getPrice());
		pstmt.setInt(4, dto.getQuantity());
		
		
		int nori=pstmt.executeUpdate();
		
		if(nori!=1)
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






public boolean deletecart(int id)
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("delete from cart where id=?");
		pstmt.setInt(1, id);
		
		int nori=pstmt.executeUpdate();
		
		if(nori!=1)
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


public List<CartDTO> DisplayAll()
{
	List<CartDTO> cakes=new ArrayList<CartDTO>();
	Connection con=CakeShopDBUtility.getConnection();	
	try 
	{
		PreparedStatement pstmt=con.prepareStatement("select *, count(*),sum(price) From cart group by cakename");		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			CartDTO dto=new CartDTO();
			
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getInt(4));
			dto.setCartcount(rs.getString(5));
			dto.setAddtotal(rs.getDouble(6));
			cakes.add(dto);
		}
		} 
	catch (SQLException e)
	{	
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return cakes;
}



public List<CartDTO> Total()
{	
	List<CartDTO> cakes=new ArrayList<CartDTO>();
	Connection con=CakeShopDBUtility.getConnection();	
	try 
	{
		PreparedStatement pstmt=con.prepareStatement("select * from cart");		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			CartDTO dto=new CartDTO();
			
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getInt(4));
			cakes.add(dto);
		}
		} 
	catch (SQLException e)
	{	
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return cakes;
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

public userdto search(String email)
{
	userdto dto=null;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try 
	{
		PreparedStatement pstmt=con.prepareStatement("select * from user where emailid=?");
		pstmt.setString(1, email);
		
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			dto=new userdto();
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

public boolean truncatecart()
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("truncate table cart");
        pstmt.executeUpdate();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
		res=false;
	}
	CakeShopDBUtility.closeConnection(con);
	return res;
}

public String Count()
{
	String count=null;
	Connection con=CakeShopDBUtility.getConnection();	
	try 
	{
		
		PreparedStatement pstmt=con.prepareStatement("select count(*) from cart");		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
		count=rs.getString(1);
		}
		} 
	catch (SQLException e)
	{	
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return count;
}




public String groupCount()
{
	String count=null;
	Connection con=CakeShopDBUtility.getConnection();	
	try 
	{
		
		PreparedStatement pstmt=con.prepareStatement("select count(*) from");		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
		count=rs.getString(1);
		}
		} 
	catch (SQLException e)
	{	
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return count;
}





}
