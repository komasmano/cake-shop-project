package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kk.app.DAO.OrderBookDAO;
import com.kk.app.DTO.Cakeuserdto;
import com.kk.app.DTO.OrderBookDTO;

/**
 * Servlet implementation class DisplatAllorders
 */
public class DisplayAllorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	OrderBookDAO dao=new OrderBookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		RequestDispatcher rd1=request.getRequestDispatcher("JSP/Admin.jsp");
		
		List<OrderBookDTO> orders=dao.Displayorder();
		
		request.setAttribute("orders", orders);
		rd1.forward(request, response);
		
		
		
	}

}
