package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kk.app.DAO.CartDAO;

/**
 * Servlet implementation class CartBackController
 */
public class CartBackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	    CartDAO dao=new CartDAO();
    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException
    	{
		
    		
    		String count="";
    		RequestDispatcher rd=request.getRequestDispatcher("JSP/CakeView.jsp");
    			
    		count=dao.Count();
    		request.setAttribute("count", count);
			rd.forward(request, response);
	    }

}
