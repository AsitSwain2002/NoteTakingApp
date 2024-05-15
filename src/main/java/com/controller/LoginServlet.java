package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Dto.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDao udo = new UserDao();
		User user = udo.fetchUserByEmail(email);
		HttpSession session = req.getSession();
		 if(user != null){	
				String pas = user.getPassword();
			 if(password.equals(pas))
			 {
				 session.setAttribute("user", user);
				 resp.sendRedirect("home.jsp");				 
			 }
			 else{
				 session.setAttribute("wrong", "Invalid Password");
				 resp.sendRedirect("login.jsp");
			 }
			 
		 }else {
			 session.setAttribute("wrong2", "Invalid Email");
			 resp.sendRedirect("login.jsp");
		 }
		
	}

}
