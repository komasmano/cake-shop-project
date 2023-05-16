package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kk.app.DAO.CakeDAO;
import com.kk.app.DTO.CakeDTO;

/**
 * Servlet implementation class cakeDisplayAllController
 */
public class cakeDisplayAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  CakeDAO dao=new CakeDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		
	List<CakeDTO> cakes=dao.DisplayAll();	
	RequestDispatcher rd=request.getRequestDispatcher("JSP/Admin.jsp");
	request.setAttribute("cakes", cakes);
	rd.forward(request, response);
	}

}
