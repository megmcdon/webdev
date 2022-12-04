package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/checkout")
public class Checkout extends HttpServlet {
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
		HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		request.setAttribute("cart", cart);
		// load user info from db
		String username = request.getRemoteUser();
		User user  = null;
		try (Connection con = ds.getConnection()) {
			try (PreparedStatement ps = con.prepareStatement("select * from customer where email = ?")) {
				ps.setObject(1, username);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						// load user details from db
						user = new User();
						user.setEmail(rs.getString("email"));
						user.setBillingAddress(rs.getString("billing_address"));
						user.setShippingAddress(rs.getString("shipping_address"));
						user.setCreditCard(rs.getString("credit_card"));
						user.setCvv(rs.getString("cvv"));
						user.setExpiry(rs.getString("expiry"));
						user.setFname(rs.getString("first_name"));
						user.setLname(rs.getString("last_name"));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		request.setAttribute("user", user);

		// get cart items from db
		request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// save cart items to db
		// confirm order and send email
		// clear cart
	}

}
