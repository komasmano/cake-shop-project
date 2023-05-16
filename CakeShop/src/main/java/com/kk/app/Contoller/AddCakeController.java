package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DTO.CakeDTO;

/**
 * Servlet implementation class AddCakeController
 */
public class AddCakeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CakeDAO dao=new CakeDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
	
		RequestDispatcher rd=request.getRequestDispatcher("JSP/AddCake.jsp");
		String msg="";
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		CakeDTO dto=new CakeDTO(id, name, price, quantity);
			
		if(dao.addcake(dto))
		{
			msg="Entry added sucessfully. . . !!!";
		}
		else
		{
			msg="Oops somthing went wrong. . . !!!";
		}
		
		request.setAttribute("msg", msg);
		rd.forward(request, response);

		
	}

}
