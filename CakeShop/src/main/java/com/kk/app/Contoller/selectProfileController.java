package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.Cakeuserdto;

/**
 * Servlet implementation class selectProfileController
 */
public class selectProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CakeuserDAO dao=new CakeuserDAO();
	CartDAO dao1=new CartDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
   	throws ServletException, IOException 
    {
    	
    	String method="";
    	String count="";
   		RequestDispatcher rd=request.getRequestDispatcher("JSP/CakeView.jsp");
    	
    	HttpSession session=request.getSession(false);
    	String emailid=(String)session.getAttribute("emailid");
		if(dao.selectProfille(emailid) != null)
		{
		Cakeuserdto dto=dao.selectProfille(emailid);
		request.setAttribute("dto", dto); 
		method="block";	
		count=dao1.Count();
		request.setAttribute("count", count);
		request.setAttribute("method", method);
		}
		else
		{
		method="none";
		request.setAttribute("method", method);	
		}
		rd.forward(request, response);
		}
}
