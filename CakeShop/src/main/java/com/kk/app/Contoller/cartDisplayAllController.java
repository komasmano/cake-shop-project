package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.CakeDTO;
import com.kk.app.DTO.CartDTO;

/**
 * Servlet implementation class cakeDisplayAllController
 */
public class cartDisplayAllController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	    CartDAO dao=new CartDAO();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException
		{
	
		String show=request.getParameter("show");
		String check="0";
		String methds="";
		String opacity="";
		
		RequestDispatcher rd1=request.getRequestDispatcher("JSP/CartDisplayAll.jsp");
		RequestDispatcher rd2=request.getRequestDispatcher("JSP/CakeView.jsp");
		List<CartDTO> cakes=dao.DisplayAll();
		List<CartDTO> totalamt=dao.Total();
		if(show.equals(check))
		{	
		methds="block";	
	    opacity="0.1";
	    request.setAttribute("opacity", opacity);
	    request.setAttribute("methds", methds);
		rd2.forward(request, response);	
		}
		else
		{
		request.setAttribute("cakes", cakes);
		request.setAttribute("totalamt", totalamt);
		rd1.forward(request, response);		
		}
		}
}
