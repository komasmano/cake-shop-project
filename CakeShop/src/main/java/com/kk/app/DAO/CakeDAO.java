package com.kk.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kk.app.DBUtility.CakeShopDBUtility;
import com.kk.app.DTO.CakeDTO;

public class CakeDAO 
{


	
	
public boolean addcake(CakeDTO dto)
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("insert into cake values(?,?,?,?)");
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


public boolean deletecake(int id)
{
	
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try
	{
		PreparedStatement pstmt=con.prepareStatement("delete from cake where id=?");
		
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


public List<CakeDTO> DisplayAll()
{
	List<CakeDTO> cakes=new ArrayList<CakeDTO>();
	Connection con=CakeShopDBUtility.getConnection();	
	try 
	{
		PreparedStatement pstmt=con.prepareStatement("select * from cake");		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			CakeDTO dto=new CakeDTO();
			
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
	


public CakeDTO search(int cakeid)
{
    CakeDTO dto=null;
	List<CakeDTO> cakes=DisplayAll();

	for(CakeDTO cake:cakes)
	{
		
		if(cake.getId() == cakeid)
		{
			System.out.println("yes");
			System.out.println(cake.getId());
			System.out.println(cake.getCakename());
			System.out.println(cake.getPrice());
			System.out.println(cake.getQuantity());
			dto=cake;
		}
	}

	return dto;
}

public boolean update(CakeDTO dto)
{
	boolean res=true;
	
	Connection con=CakeShopDBUtility.getConnection();
	
	try 
	{
		PreparedStatement pstmt=con.prepareStatement("update cake set cakename=?, Price=?, Quantity=? where id=?");
		pstmt.setString(1, dto.getCakename());
		pstmt.setDouble(2, dto.getPrice());
		pstmt.setInt(3, dto.getQuantity());
		pstmt.setInt(4, dto.getId());
		
		
		int noru=pstmt.executeUpdate();
		
		if(noru!= 1)
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


}
