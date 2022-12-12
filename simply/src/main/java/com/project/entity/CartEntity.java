package com.project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CART")
public class CartEntity implements Serializable {
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
    @ManyToOne
    @JoinColumn(name = "c_o_id")
    private OrdersEntity order;

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

    public OrdersEntity getOrder() {
        return order;
    }
    public void setOrder( OrdersEntity order ) {
        this.order = order;
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( !( o instanceof CartEntity ) ) return false;
        CartEntity that = ( CartEntity ) o;
        return id == that.id && quantity == that.quantity && Objects.equals( product, that.product ) && Objects.equals( user, that.user ) && Objects.equals( order, that.order );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, product, user, quantity, order );
    }
}
