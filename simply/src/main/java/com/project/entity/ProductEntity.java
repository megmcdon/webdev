package com.project.entity;
import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="p_id") private int id;
	@Column(name="p_name") private String name;
	@Column(name="p_description") private String description;
	@Column(name="p_price") private Double price;
	@Column(name="p_stock") private int stock;
	@Column(name="p_category") private String category;
	@Column(name="p_discount_perc") private int discountPerc;
	
	
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
	
	public void setFirstName(String name) {
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
	public void setPrice(Double price) {
		this.price = price;
	}
	
	//out_of_stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//category
	public String getCategory() {
		return category;
	}
	public void setEmail(String category) {
		this.category = category;
	}
	
	//discount_perc
	public int getDiscountPerc() {
		return discountPerc;
	}
	public void setPassword(int discountPerc) {
		this.discountPerc = discountPerc;
	}

	
	
}
