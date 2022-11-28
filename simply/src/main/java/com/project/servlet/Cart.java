package com.project.servlet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Product, Integer> products = new HashMap<>();

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	public BigDecimal getTotal() {
		return products.entrySet().stream().map(x -> x.getKey().getPrice().multiply(new BigDecimal(x.getValue())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
