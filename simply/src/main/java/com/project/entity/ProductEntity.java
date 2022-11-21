package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductEntity {
	
	@Id
	@GeneratedValue
	@Column(name="p_id") private int id;
	@Column(name="p_name") private String name;
	@Column(name="p_description") private String description;
	@Column(name="p_price") private Double price;
	@Column(name="p_out_of_stock") private Boolean out_of_stock;
	@Column(name="p_category") private String category;
	@Column(name="p_discount_perc") private int discount_perc;
	
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//name
	public String getName() {
		return name;
	}
	
	public void setFirst_name(String name) {
		this.name = name;
	}
	
	//description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//price
	public Double getPrice() {
		return price;
	}
	public void setBilling_addr(Double price) {
		this.price = price;
	}
	
	//out_of_stock
	public Boolean getOut_of_stock() {
		return out_of_stock;
	}
	public void setShipping_Addr(Boolean out_of_stock) {
		this.out_of_stock = out_of_stock;
	}
	
	//category
	public String getCategory() {
		return category;
	}
	public void setEmail(String category) {
		this.category = category;
	}
	
	//discount_perc
	public int getDiscount_perc() {
		return discount_perc;
	}
	public void setPassword(int discount_perc) {
		this.discount_perc = discount_perc;
	}

	
	
}
