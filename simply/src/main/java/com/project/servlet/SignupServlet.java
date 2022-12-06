package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

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
	 * ~USER SIGNUP~
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=new UserEntity();
		user.setPassword(request.getParameter("password"));
		String confirmPassword = request.getParameter("confirmPassword");
		// TODO: Compare if passwords are same
		user.setFirst_name(request.getParameter("fname"));
		user.setLast_name(request.getParameter("lname"));
		user.setBilling_addr(request.getParameter("ba"));
		user.setShipping_Addr(request.getParameter("sa"));
		user.setEmail(request.getParameter("email"));
		user.setCc_num(Integer.parseInt(request.getParameter("cc")));
		user.setCc_exp(request.getParameter("expiry"));
		user.setCc_cvv(Integer.parseInt(request.getParameter("cvv")));
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
