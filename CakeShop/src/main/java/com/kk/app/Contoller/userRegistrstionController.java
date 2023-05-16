package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DTO.Cakeuserdto;

public class userRegistrstionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	CakeuserDAO dao=new CakeuserDAO();
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException
   	{
   		String msgs="";
   		String method="";
   		RequestDispatcher rd=request.getRequestDispatcher("JSP/Home.jsp");
	
   		String emailid=request.getParameter("emailid");
   		String password=request.getParameter("password");
   		long contactno=Long.parseLong(request.getParameter("contactno"));
   		String name=request.getParameter("name");
   		
   		Cakeuserdto dto=new Cakeuserdto(emailid, password, contactno, name);
   		if(dao.userPresent(dto))
   		{
   			msgs="Mail Id alrady exits...";
   		}
   		else if(dao.Registration(dto))
   	    {
   		    msgs="Registration sucessfully completed";
   		}
   		else
   		{
   			msgs="Somthing went wrong";
   		}
   		method="block";
   		request.setAttribute("msgs", msgs);
   		request.setAttribute("method", method);
   		rd.forward(request, response);
		}
}
