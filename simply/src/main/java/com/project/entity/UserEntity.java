package com.project.entity;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name="u_id") private int id;
	@Column(name="u_first_name") private String first_name;
	@Column(name="u_last_name") private String last_name;
	@Column(name="u_billing_addr") private String billing_addr;
	@Column(name="u_shipping_addr") private String shipping_addr;
	@Column(name="u_email") private String email;
	@Column(name="u_password") private String password;
	@Column(name="u_cc_info") private int cc_info;
	
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//first_name
	public String getFirst_Name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	//last_name
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	//billing_addr
	public String getBilling_addr() {
		return billing_addr;
	}
	public void setBilling_addr(String billing_addr) {
		this.billing_addr = billing_addr;
	}
	
	//shipping_addr
	public String getShipping_addr() {
		return shipping_addr;
	}
	public void setShipping_Addr(String shipping_addr) {
		this.shipping_addr = shipping_addr;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//cc_info
	public int GetCc_info() {
		return cc_info;
	}
	public void setCc_info(int cc_info) {
		this.cc_info = cc_info;
	}
	
	
}
