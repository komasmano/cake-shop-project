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
 * Servlet implementation class searchcakeController
 */
public class searchcakeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CakeDAO dao=new CakeDAO();
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
   	throws ServletException, IOException
   	{
   	
   		RequestDispatcher rd1=request.getRequestDispatcher("JSP/SearchCake.jsp");
   		RequestDispatcher rd2=request.getRequestDispatcher("JSP/UpdateCake.jsp");
   		String option=request.getParameter("option"); 
   		String msg="";
   		
   		int cakeid=Integer.parseInt(request.getParameter("id"));
   		CakeDTO dto=dao.search(cakeid);
   		
   		if(dto != null)
   			
   		{
   		request.setAttribute("cakes", dto);
   		}
   		else
   		{
   		msg="Invaild Cake ID...!!!";
   		request.setAttribute("msg", msg);	
   		}
   		
   		if(option.equals("search"))
   		{
   			rd1.forward(request, response);
   		}
   		else
   		{
   			rd2.forward(request, response);
   		}
	    }

}
