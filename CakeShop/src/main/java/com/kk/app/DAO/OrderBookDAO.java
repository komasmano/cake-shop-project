package com.kk.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kk.app.DBUtility.CakeShopDBUtility;
import com.kk.app.DTO.OrderBookDTO;

public class OrderBookDAO {

	
	public boolean addOrder(OrderBookDTO dto)
	{
		boolean res=true;
		
		Connection con=CakeShopDBUtility.getConnection();
		System.out.println(dto.getId());
		System.out.println(dto.getCakename() );
		System.out.println(dto.getPrice());
		System.out.println(dto.getOrderno() );
		System.out.println(dto.getTotal());
		
		try
		{
			PreparedStatement pstmt=con.prepareStatement("insert into delivery1 values(?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getCakename());
			pstmt.setDouble(3, dto.getPrice());
			pstmt.setString(4, dto.getQuantity());
			pstmt.setDouble(5, dto.getTotal());
			pstmt.setInt(6, dto.getOrderno());
			pstmt.setString(7, dto.getUsername());
			pstmt.setLong(8, dto.getContactno());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getDate());
			pstmt.setString(11, dto.getTime());
			
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
	
	
	public boolean totalOrder(OrderBookDTO dto)
	{
		boolean res=true;
		
		Connection con=CakeShopDBUtility.getConnection();
		System.out.println(dto.getId());
		System.out.println(dto.getCakename() );
		System.out.println(dto.getPrice());
		System.out.println(dto.getOrderno() );
		System.out.println(dto.getTotal());
		
		try
		{
			PreparedStatement pstmt=con.prepareStatement("insert into delivery1 values(?,?,?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getCakename());
			pstmt.setDouble(3, dto.getTotal());
			pstmt.setInt(4, dto.getOrderno());
			pstmt.setString(5, dto.getUsername());
			pstmt.setLong(6, dto.getContactno());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getDate());
			pstmt.setString(9, dto.getTime());
			
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
	

	public boolean checkorderno(int orderno)
	{
		boolean res=true;	
		Connection con=CakeShopDBUtility.getConnection();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("SELECT * FROM delivery1 where orderno=?");
			pstmt.setInt(1, orderno);
			
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

	
	
	
	
	
	
	public boolean Quantity(int id)
	{
		boolean res=true;
		
		
		
		Connection con=CakeShopDBUtility.getConnection();
		
		try
		{
			PreparedStatement pstmt=con.prepareStatement("update cake set Quantity=Quantity-1 where id=?");
			
			pstmt.setInt(1, id);
			
			int noru=pstmt.executeUpdate();
			
			if(noru!=1)
			{
				return false;
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
	
	
public List<OrderBookDTO> Displayorder()
{
	
	List<OrderBookDTO> order=new ArrayList<OrderBookDTO>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement("select * from delivery1");
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		 OrderBookDTO dto=new OrderBookDTO();
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getString(4));
			dto.setAddamount(rs.getDouble(5));
			dto.setOrderno(rs.getInt(6));
			dto.setUsername(rs.getString(7));
			dto.setContactno(rs.getLong(8));
			dto.setAddress(rs.getString(9));
			dto.setDate(rs.getString(10));
			dto.setTime(rs.getString(11));
			order.add(dto);
		}
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return order;
}
	

public List<OrderBookDTO> BillDisplayorder(int orderno)
{
	
	List<OrderBookDTO> order=new ArrayList<OrderBookDTO>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement("SELECT * FROM delivery1 where orderno=? and cakename is not null");
		pstmt.setInt(1, orderno);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		 OrderBookDTO dto=new OrderBookDTO();
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getString(4));
			dto.setAddamount(rs.getDouble(5));
			dto.setOrderno(rs.getInt(6));
			dto.setUsername(rs.getString(7));
			dto.setContactno(rs.getLong(8));
			dto.setAddress(rs.getString(9));
			dto.setDate(rs.getString(10));
			dto.setTime(rs.getString(11));
			order.add(dto);
		}
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return order;
}


public List<OrderBookDTO> orderTotalAmount(int orderno)
{
	
	List<OrderBookDTO> order=new ArrayList<OrderBookDTO>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement("SELECT * FROM delivery1 where orderno=? and cakename is null");
		pstmt.setInt(1, orderno);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		 OrderBookDTO dto=new OrderBookDTO();
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getString(4));
			dto.setAddamount(rs.getDouble(5));
			dto.setOrderno(rs.getInt(6));
			dto.setUsername(rs.getString(7));
			dto.setContactno(rs.getLong(8));
			dto.setAddress(rs.getString(9));
			dto.setDate(rs.getString(10));
			dto.setTime(rs.getString(11));
			order.add(dto);
		}
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return order;
}



public List<OrderBookDTO> BillDisplayorderadmin()
{
	
	List<OrderBookDTO> order=new ArrayList<OrderBookDTO>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement("SELECT * FROM delivery1 where orderno= and cakename is not null");
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		 OrderBookDTO dto=new OrderBookDTO();
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getString(4));
			dto.setAddamount(rs.getDouble(5));
			dto.setOrderno(rs.getInt(6));
			dto.setUsername(rs.getString(7));
			dto.setContactno(rs.getLong(8));
			dto.setAddress(rs.getString(9));
			dto.setDate(rs.getString(10));
			dto.setTime(rs.getString(11));
			order.add(dto);
		}
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return order;
}


public List<OrderBookDTO> orderTotalAmountadmin(int orderno)
{
	
	List<OrderBookDTO> order=new ArrayList<OrderBookDTO>();
	
	Connection con=CakeShopDBUtility.getConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement("SELECT * FROM delivery1 where orderno=? and cakename is null");
		pstmt.setInt(1, orderno);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		 OrderBookDTO dto=new OrderBookDTO();
			dto.setId(rs.getInt(1));
			dto.setCakename(rs.getString(2));
			dto.setPrice(rs.getDouble(3));
			dto.setQuantity(rs.getString(4));
			dto.setAddamount(rs.getDouble(5));
			dto.setOrderno(rs.getInt(6));
			dto.setUsername(rs.getString(7));
			dto.setContactno(rs.getLong(8));
			dto.setAddress(rs.getString(9));
			dto.setDate(rs.getString(10));
			dto.setTime(rs.getString(11));
			order.add(dto);
		}
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	CakeShopDBUtility.closeConnection(con);
	return order;
}
	
	
	
}
