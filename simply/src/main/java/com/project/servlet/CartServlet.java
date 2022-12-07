package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	 * GETS CART AND FORWARDS REQUEST ATTRIBUTE cart TO /cart.jsp
	 * IF USER NOT LOGGED IN, FORWARD TO /login.jsp
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

		}
		else {
		request.setAttribute("cart", db.getCart(user.getId()));
		request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		}
	}

	/**
	 *SAVES ITEM TO CART, TAKES REQUEST PARAMETERS p_id AND quantity
	 *REFUSES TO ADD MORE QUANTITY TO CART THAN AVAILABLE STOCK
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

		}
		else {
			CartEntity add = new CartEntity();
			add.setPid(Integer.parseInt(request.getParameter("p_id")));
			add.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			add.setUid(user.getId());
			if(db.addToCart(add)) {
				//TODO redirect client back to whatever page they were on
			}
			else {
				//TODO redirect client and tell them there isn't enough stock 
			}
			
		}
		
	}

}
