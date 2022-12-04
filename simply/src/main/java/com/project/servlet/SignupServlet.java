package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	private DataSource ds;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/simplycoffee");
			System.out.println("Ds " + ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: dont allow user to sign up if alreay logged on
		request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		// TODO: Compare if passwords are same
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String billingAddress = request.getParameter("ba");
		String shippingAddress = request.getParameter("sa");
		String email = request.getParameter("email");
		String creditCard = request.getParameter("cc");
		String expiry = request.getParameter("expiry");
		String cvv = request.getParameter("cvv");
		// sign up user
		try (Connection con = ds.getConnection()) {

			try (PreparedStatement ps = con.prepareStatement(
					"insert into customer(first_name,last_name,email,billing_address,shipping_address,credit_card,expiry,cvv,password) values(?,?,?,?,?,?,?,?,?)")) {

				ps.setObject(1, fname);
				ps.setObject(2, lname);
				ps.setObject(3, email);
				ps.setObject(4, billingAddress);
				ps.setObject(5, shippingAddress);
				ps.setObject(6, creditCard);
				ps.setObject(7, expiry);
				ps.setObject(8, cvv);
				ps.setObject(9, password);
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrror!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		System.out.println("Customer Successfully Signed Up");
		// automatically login
		request.login(email, password);
		// redirect to checkout
		response.sendRedirect(request.getContextPath() + "/checkout");

	}

}
