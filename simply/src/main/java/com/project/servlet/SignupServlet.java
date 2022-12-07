package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.project.dbservice.DBAccessService;
import com.project.entity.UserEntity;
import com.project.repo.UserRepo;

/**
 * Servlet implementation class SignupServlet
 * ENDPOINT RENAMED TO /user
 */
@WebServlet("/user")
public class SignupServlet extends HttpServlet {	
	@Autowired
	DBAccessService db;
	
	public void init(ServletConfig config) {
	    try {
			super.init(config);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	  }

	/**
	 * ~LOGGS IN USER~
	 * REQUEST PARAMETERS: email, password
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity activeUser=(UserEntity)session.getAttribute("user");
		if(activeUser!=null) {
			//TODO: tell user they can't log in again
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else {
			Optional<UserEntity> user =db.login(request.getParameter("email"), request.getParameter("password"));
			if(user.isPresent()) {
				session.setAttribute("user", user.get());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

	/**
	 * MAINTAINS SAME REQUEST PARAMETERS AS BEFORE
	 * SIGNS UP USER AND LOGS IN 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=new UserEntity();
		user.setPassword(request.getParameter("password"));
		String confirmPassword = request.getParameter("confirmPassword");
		// TODO: Compare if passwords are same
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setBillingAddr(request.getParameter("ba"));
		user.setShipping_Addr(request.getParameter("sa"));
		user.setEmail(request.getParameter("email"));
		user.setCcnum(Integer.parseInt(request.getParameter("cc")));
		user.setCcexp(request.getParameter("expiry"));
		user.setCccvv(Integer.parseInt(request.getParameter("cvv")));
		// sign up user
		if(db.signUp(user)) {
			// automatically login
			System.out.println("Customer Successfully Signed Up");
			user=db.login(user.getEmail(), user.getPassword()).get();
			session.setAttribute("user", user);
		}
		else {
			System.out.println("Customer Failed SignUp");
		}
		
		// redirect to index after login
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
