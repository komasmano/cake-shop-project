package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kk.app.DAO.CartDAO;

/**
 * Servlet implementation class userlogoutController
 */
public class userlogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	CartDAO dao=new CartDAO();
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		   throws ServletException, IOException 
       {
	   
	   RequestDispatcher rd1=request.getRequestDispatcher("JSP/Home.jsp");
	   
	   
	   HttpSession session=request.getSession(false);
	   String emailid=(String)session.getAttribute("emailid");
	   
	   if(emailid!=null)
	   {
	   System.out.println(emailid);   
	   session.removeAttribute(emailid);
	   session.invalidate();
	   dao.truncatecart();
	   rd1.forward(request, response);
	   }
	   
}
}