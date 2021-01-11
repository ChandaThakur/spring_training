package com.zensar;


import java.io.IOException;

import javax.servlet.http.*;

public class TestController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		TestRepository er=new TestRepository();
		
		boolean loginResult=er.checkLogin(username, password);
		
		if(loginResult) {
			System.out.println("Login Successful");
			try {
				response.sendRedirect("result.jsp");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("Login Failed");
			try {
				response.sendRedirect("login.jsp?loginStatus=fail");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
