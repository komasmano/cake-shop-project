package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.CakeDTO;
import com.kk.app.DTO.CartDTO;

/**
 * Servlet implementation class AddCartController
 */
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CartDAO dao=new CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
	
		RequestDispatcher rd=request.getRequestDispatcher("JSP/CakeView.jsp");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		CartDTO dto=new CartDTO(id, name, price, quantity);
		String count="";
		
		if(dao.addcart(dto))
			{
			count=dao.Count();
			}
			request.setAttribute("count", count);
			rd.forward(request, response);
	        }

}
