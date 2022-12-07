package com.project.entity;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="u_id") private int id;
	@Column(name="u_first_name") private String firstName;
	@Column(name="u_last_name") private String lastName;
	@Column(name="u_billing_addr") private String billingAddr;
	@Column(name="u_shipping_addr") private String shippingAddr;
	@Column(name="u_email") private String email;
	@Column(name="u_password") private String password;
	@Column(name="u_cc_num") private int ccnum;
	@Column(name="u_cc_cvv") private int cccvv;
	@Column(name="u_cc_exp") private String ccexp;
	@Column(name="u_admin") private boolean admin;
	
	//getters and setters//
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//first_name
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//last_name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//billing_addr
	public String getBillingAddr() {
		return billingAddr;
	}
	public void setBillingAddr(String billingAddr) {
		this.billingAddr = billingAddr;
	}
	
	//shipping_addr
	public String getShippingAddr() {
		return shippingAddr;
	}
	public void setShipping_Addr(String shippingAddr) {
		this.shippingAddr = shippingAddr;
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
	
	//cc_num
	public int GetCcnum() {
		return ccnum;
	}
	public void setCcnum(int ccnum) {
		this.ccnum = ccnum;
	}
	
	
	public int getCccvv() {
		return cccvv;
	}
	public void setCccvv(int cccvv) {
		this.cccvv = cccvv;
	}
	public String getCcexp() {
		return ccexp;
	}
	public void setCcexp(String ccexp) {
		this.ccexp = ccexp;
	}
	//admin
	public boolean GetAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
