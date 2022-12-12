package com.project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="o_id") private int id;
	@Column(name="o_u_id") private int uid;
	@Column(name="o_total") private Double total;
	@Column(name="o_date") private LocalDate date;
	@OneToMany( mappedBy = "order" )
	private List<CartEntity> carts = new ArrayList<>();
	
	
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
	public Double getTotal() {
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

	public List<CartEntity> getCarts() {
		return carts;
	}
	public void setCarts( List<CartEntity> carts ) {
		this.carts = carts;
	}

	@Override
	public boolean equals( Object o )
	{
		if( this == o ) return true;
		if( !( o instanceof OrdersEntity ) ) return false;
		OrdersEntity that = ( OrdersEntity ) o;
		return id == that.id && uid == that.uid && Objects.equals( total, that.total ) && Objects.equals( date, that.date ) && Objects.equals( carts, that.carts );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( id, uid, total, date, carts );
	}
}
