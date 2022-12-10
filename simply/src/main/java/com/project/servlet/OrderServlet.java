package com.project.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.project.dbservice.DBAccessService;
import com.project.entity.CartEntity;
import com.project.entity.OrdersEntity;
import com.project.entity.UserEntity;

import com.project.email.*;

@WebServlet("/checkout")
public class OrderServlet extends HttpServlet {
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
	
	//RETURNS REQUEST ATTRIBUTE orders
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

		}
		else {
			request.setAttribute("orders", db.getOrders(user.getId()));
			request.getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);
			
		}
		//TODO return ArrayList<OrderEntity> with orders from user
		System.out.println("pass");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO create order, save order, empty cart, send email confirmation, update stock
		HttpSession session = request.getSession(true);
		UserEntity user=(UserEntity) session.getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

		}
		else {
		/*
		ArrayList<CartEntity> cart = db.getCart(user.getId());
		System.out.println("pass");
		/*
		if(db.validateOrder(cart)) {
			//TODO: comfirmation email
			OrdersEntity newOrder = db.confirmOrder(cart, user.getId());
			newOrder.setTotal(Double.parseDouble(request.getParameter("total")));
			newOrder.setUid(user.getId());
			
			String cartHTML="hi";
			db.sendEmail("meghanymcdonough@gmail.com", "Meghan", 12.3, 3, "html table");
			
			//TODO: do something with newOrder
			

			
		}
		else {
			System.out.println("pass");
			//TODO: order failure scenario
		}
		*/

		
		
		}
		
	}

}
