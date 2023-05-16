package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DTO.Cakeuserdto;

/**
 * Servlet implementation class userDisplayAll
 */
public class userDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	CakeuserDAO dao=new CakeuserDAO();
    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException 
    	{
    		
    		RequestDispatcher rd1=request.getRequestDispatcher("JSP/Admin.jsp");
    		
    		List<Cakeuserdto> users=dao.DisplayAlluser();
    		
    		request.setAttribute("users", users);
    		rd1.forward(request, response);
    		
		}

}
