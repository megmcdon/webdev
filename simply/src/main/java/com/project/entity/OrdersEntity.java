package com.project.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity {
	
	@Id
	@GeneratedValue
	@Column(name="o_id") private int id;
	@Column(name="o_u_id") private int uid;
	@Column(name="o_total") private Double total;
	@Column(name="o_date") private LocalDate date;
	
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//u_id
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	//total
	public Double GetTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	//date
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
