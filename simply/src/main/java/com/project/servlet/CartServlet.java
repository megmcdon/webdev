package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import com.project.entity.CartEntity;
import com.project.entity.UserEntity;

/**
 * Servlet implementation class Checkout
 * RENAMED TO /cart!!!!
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DBAccessService db;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

		}
		else {
		request.setAttribute("cart", db.getCart(user.getId()));
		request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//This will save an item to cart, needs request parameters p_id and quantity
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

		}
		else {
			CartEntity add = new CartEntity();
			add.setP_id(Integer.parseInt(request.getParameter("p_id")));
			add.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			add.setU_id(user.getId());
			if(db.addToCart(add)) {
				
			}
			
		}
		
	}

}
