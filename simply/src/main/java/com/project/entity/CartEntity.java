package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "CART")
public class CartEntity {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "c_p_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "c_u_id")
    private UserEntity user;
    @Column(name = "c_quantity")
    private int quantity;

    //getters and setters//
    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
