package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity {
	
	@Id
	@GeneratedValue
	@Column(name="o_id") private int id;
	@Column(name="o_u_id") private int u_id;
	@Column(name="o_total") private Double total;
	
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//u_id
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	//total
	public Double GetTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
	
}
