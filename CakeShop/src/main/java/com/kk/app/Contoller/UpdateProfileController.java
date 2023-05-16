package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.Cakeuserdto;

/**
 * Servlet implementation class UpdateProfileController
 */
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CakeuserDAO dao=new CakeuserDAO();
	CartDAO dao1=new CartDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		
		String method="";
   		RequestDispatcher rd=request.getRequestDispatcher("JSP/CakeView.jsp");
    	
		String emailid=request.getParameter("emailid");
   		String password=request.getParameter("password");
   		long contactno=Long.parseLong(request.getParameter("contactno"));
   		String name=request.getParameter("name");
   		
   		Cakeuserdto dto=new Cakeuserdto(emailid, password, contactno, name);
   		String count="";
   		if(dao.updateProfile(dto))
   		{
   		method="none";	
   		count=dao1.Count();		
   		}
   		request.setAttribute("count", count);
   		request.setAttribute("method", method); 
   		rd.forward(request, response);
}

}
