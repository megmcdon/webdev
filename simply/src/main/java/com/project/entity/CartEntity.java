package com.project.entity;

import javax.persistence.*;
@Entity
@Table(name = "CART")
public class CartEntity {
	
	@Id
	@GeneratedValue
	@Column(name="c_id") private int id;
	@Column(name="c_p_id") private int p_id;
	@Column(name="c_u_id") private int u_id;
	@Column(name="c_quantity") private int quantity;
	
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//p_id
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	//u_id
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	//quantity
	public int GetQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
