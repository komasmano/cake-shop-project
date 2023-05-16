package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import com.kk.app.DAO.CartDAO;
import com.kk.app.DAO.OrderBookDAO;
import com.kk.app.DTO.CartDTO;
import com.kk.app.DTO.OrderBookDTO;

/**
 * Servlet implementation class orderController
 */
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CartDAO dao=new CartDAO();
	OrderBookDAO dao1=new OrderBookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
	
		
	String name="";	
	long contactno;	
	int ordno = 0;
	
	
	java.util.Date dates = new java.util.Date();
	
	SimpleDateFormat date_format = new SimpleDateFormat("dd MMMM yyyy");
     
    String date = date_format.format(dates);
    
    
    LocalTime times=LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time=times.format(formatter);
    
	RequestDispatcher rd=request.getRequestDispatcher("JSP/orderPlaced.jsp");
	
	
	List<CartDTO> cakes=dao.DisplayAll();
	
	
	for(CartDTO cake:cakes)
	{
	int cakeid=cake.getId();	
	String cakename=cake.getCakename();
	Double price=cake.getPrice();
	ordno=Integer.parseInt(request.getParameter("orderno"));
	String quantity=cake.getCartcount();
	double addamount=cake.getAddtotal();
	
	System.out.println(cakeid);
	System.out.println(cakename);
	System.out.println(price);
	System.out.println(ordno);
	System.err.println(addamount);
	
    OrderBookDTO dto=new OrderBookDTO(cakeid, cakename, price, quantity, addamount, ordno);
    
	dao1.addOrder(dto);
	
	int id=cake.getId();
	dao1.Quantity(id);

	}
	
	int orderno=Integer.parseInt(request.getParameter("orderno"));
	double Total=Double.parseDouble(request.getParameter("total"));
	String Address=request.getParameter("address");
	String  username=request.getParameter("username");
	name=username;
	contactno=Long.parseLong(request.getParameter("contactno"));
	
	
    OrderBookDTO dto=new OrderBookDTO(Total, Address, date, time, orderno, username, contactno);
    
	if(dao1.addOrder(dto))
	{
		List<OrderBookDTO> orders=dao1.BillDisplayorder(orderno);
		List<OrderBookDTO> totalamt=dao1.orderTotalAmount(orderno);
		
		request.setAttribute("name", name);
		request.setAttribute("contactno", contactno);
		request.setAttribute("orderno", ordno);
		request.setAttribute("orders", orders);
		request.setAttribute("totalamt", totalamt);
		
	}
	dao.truncatecart();
	
	rd.forward(request, response);	
	}

}
