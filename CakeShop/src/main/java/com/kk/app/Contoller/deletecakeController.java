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
 * Servlet implementation class cakedeleteController
 */
public class deletecakeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CakeDAO dao=new CakeDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		RequestDispatcher rd=request.getRequestDispatcher("JSP/DeleteCake.jsp");
		String msg="";
		int id=Integer.parseInt(request.getParameter("id"));
		
		if(dao.deletecake(id))
		{
			msg="Entry deleted sucessfully. . . !!!";
		}
		else
		{
			msg="Oops somthing went wrong. . . !!!";
		}
		
		request.setAttribute("msg", msg);
		rd.forward(request, response);

		
	
	
	}

}
