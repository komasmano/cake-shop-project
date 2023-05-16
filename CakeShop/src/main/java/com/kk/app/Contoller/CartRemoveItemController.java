package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.CartDTO;

/**
 * Servlet implementation class CartRemoveItemController
 */
public class CartRemoveItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	CartDAO dao=new CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println();
		
		RequestDispatcher rd1=request.getRequestDispatcher("JSP/CartDisplayAll.jsp");
	
		if(dao.deletecart(id))
		{
		List<CartDTO> cakes=dao.DisplayAll();
		List<CartDTO> totalamt=dao.Total();
		request.setAttribute("cakes", cakes);
		request.setAttribute("totalamt", totalamt);
		rd1.forward(request, response);
		}
		else
		{
			List<CartDTO> cakes=dao.DisplayAll();
			List<CartDTO> totalamt=dao.Total();
			request.setAttribute("cakes", cakes);
			request.setAttribute("totalamt", totalamt);
			rd1.forward(request, response);
			
		}
		}
   }
