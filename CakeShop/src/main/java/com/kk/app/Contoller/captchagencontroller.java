package com.kk.app.Contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import com.kk.app.DAO.CakeuserDAO;

/**
 * Servlet implementation class captchagencontroller
 */
public class captchagencontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CakeuserDAO dao=new CakeuserDAO();
    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException
    	
    	{
      		String mtd="";
    	  		
    		RequestDispatcher rd=request.getRequestDispatcher("JSP/Home.jsp");

            String cap=toString(dao.captcha());
    		
            mtd="block";
   	   		request.setAttribute("mtd", mtd);
            System.out.println(cap);
            request.setAttribute("cap", cap);
    		rd.forward(request, response);
     	}



        
        public static String toString(char[] a)
        {
            String string = new String(a);
     
            return string;
        }

}
