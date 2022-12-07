package com.project.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dbservice.DBAccessService;
import com.project.entity.CartEntity;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;

@WebServlet("/products")
public class ProductServlet {
	@Autowired
	DBAccessService db;
	
	/**
	 * LOOKS FOR PARAMETERS category OR p_id and RETURNS ACCORDINGLY
	 * REDIRECT WITH category OR NO PARAMETERS IS TO /products.jsp WITH REQUEST ATTRIBUTE products
	 * REDIRECT WITH p_id IS TO /product.jsp WITH REQUEST ATTRIBUTE product
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String category=request.getParameter("category");
		String p_id=request.getParameter("p_id");
		if(p_id!=null) {
			int id=Integer.parseInt(p_id);
			ProductEntity product = db.getProduct(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
		}
		else if(category!=null) {
			ArrayList<ProductEntity> productList = db.getProductCategory(category);
			request.setAttribute("products", productList);
			request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

		}
		else {
			ArrayList<ProductEntity> productList = db.getAllProducts();
			request.setAttribute("products", productList);
			request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO use this to let admin alter products
			
	}
		
}


