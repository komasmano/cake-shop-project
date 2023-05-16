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

import org.apache.catalina.Context;

import com.kk.app.DAO.CakeuserDAO;
import com.kk.app.DAO.CartDAO;
import com.kk.app.DTO.Cakeuserdto;
import com.kk.app.DTO.userdto;

/**
 * Servlet implementation class userloginController
 */
public class userloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CakeuserDAO dao=new CakeuserDAO();
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
  	throws ServletException, IOException 
  	{
  		String msg="";
  		String mtd="";
   		RequestDispatcher rd=request.getRequestDispatcher("JSP/Home.jsp");
	
  		String emailid=request.getParameter("emailid");
   		String password=request.getParameter("password");
   		String ran_cap=request.getParameter("len");
   		String user_cap=request.getParameter("captcha");
   		
   		System.out.println(emailid);
   		System.out.println(password);
   		
   		Cakeuserdto dto=new Cakeuserdto();
   		
   		CartDAO dao1=new CartDAO();
   		
   		dto.setEmail(emailid);
   		dto.setPassword(password);
   		
   		String name="admin";
   		String pass="cake";
   		
   		if(name.equals(emailid) && pass.equals(password))
   		{
   			if(ran_cap.equals(user_cap))
   			{
   				RequestDispatcher rd1=request.getRequestDispatcher("JSP/Admin.jsp");
   	   			rd1.forward(request, response);		
   			}
   			else
   			{
   				String cap=toString(dao.captcha());
   				msg="Invalid captcha";
   				mtd="block";
   				request.setAttribute("emailid", emailid);
   				request.setAttribute("password", password);
   				request.setAttribute("caps", cap);
   	   	   		request.setAttribute("mtds", mtd);
   	            request.setAttribute("msg1", msg);
   	        	rd.forward(request, response);
   			}
   		}
   		else if(dao.login(dto))
   		{
   			if(ran_cap.equals(user_cap))
   			{
   	   		    HttpSession session=request.getSession(true);
   	   		    session.setAttribute("emailid", emailid);
   	   			RequestDispatcher rd2=request.getRequestDispatcher("JSP/CakeHome.jsp");
   	   			rd2.forward(request, response);
   	   			}
   			else
   			{
   				String cap=toString(dao.captcha());
   				msg="Invalid captcha";
   				mtd="block";
   				request.setAttribute("emailid", emailid);
   				request.setAttribute("password", password);
   				request.setAttribute("caps", cap);
    	   		request.setAttribute("mtds", mtd);
   	            request.setAttribute("msg1", msg);
   	   	   		rd.forward(request, response);
   			}
   			
   			
   		}
   		else
   		{
   			String cap=toString(dao.captcha());
   			msg="Invaild username & password"; 
   			mtd="block";
   			request.setAttribute("cap", cap);
   	   		request.setAttribute("mtd", mtd);
            request.setAttribute("msg", msg);
   	   		rd.forward(request, response);
   		}
	}

	private String toString(char[] captcha)
	{
		String string=new String(captcha);
		return string;
	}
}
