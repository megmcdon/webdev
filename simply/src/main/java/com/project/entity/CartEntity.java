package com.project.entity;

import javax.persistence.*;
@Entity
@Table(name = "CART")
public class CartEntity {
	
	@Id
	@GeneratedValue
	@Column(name="c_id") private int id;
	@Column(name="c_p_id") private int pid;
	@Column(name="c_u_id") private int uid;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	//u_id
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	//quantity
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
