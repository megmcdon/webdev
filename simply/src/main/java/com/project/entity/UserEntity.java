package com.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "abc")
    @SequenceGenerator(name = "abc", initialValue = 100)//to avoid conflicting with admin
    @Column(name = "u_id")
    private int id;
    @NotEmpty
    @Column(name = "u_first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "u_last_name")
    private String lastName;
    @NotEmpty
    @Column(name = "u_billing_addr")
    private String billingAddr;
    @Column(name = "u_shipping_addr")
    private String shippingAddr;
    @NotEmpty
    @Column(name = "u_email")
    private String email;
    @NotEmpty
    @Column(name = "u_password")
    private String password;
    @NotNull
    @Column(name = "u_cc_num")
    private Integer ccnum;
    @NotNull
    @Column(name = "u_cc_cvv")
    private Integer cccvv;
    @NotEmpty
    @Column(name = "u_cc_exp")
    private String ccexp;
    @Column(name = "u_admin")
    private boolean admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddr() {
        return billingAddr;
    }

    public void setBillingAddr(String billingAddr) {
        this.billingAddr = billingAddr;
    }

    public String getShippingAddr() {
        return shippingAddr;
    }

    public void setShippingAddr(String shippingAddr) {
        this.shippingAddr = shippingAddr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCcnum() {
        return ccnum;
    }

    public void setCcnum(Integer ccnum) {
        this.ccnum = ccnum;
    }

    public Integer getCccvv() {
        return cccvv;
    }

    public void setCccvv(Integer cccvv) {
        this.cccvv = cccvv;
    }

    public String getCcexp() {
        return ccexp;
    }

    public void setCcexp(String ccexp) {
        this.ccexp = ccexp;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
