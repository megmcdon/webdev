package com.project.dbservice;

import java.util.ArrayList;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartEntity;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;
import com.project.entity.OrdersEntity;

import com.project.repo.CartRepo;
import com.project.repo.ProductRepo;
import com.project.repo.UserRepo;
import com.project.repo.OrderRepo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.email.*;

@Service
public class DBAccessService {
    private static final String CHECKOUT_CART = "checkout-cart";
    private static final String ADD_PRODUCTS = "add-products";

    @Autowired
    CartRepo cRepo;
    @Autowired
    UserRepo uRepo;
    @Autowired
    ProductRepo pRepo;
    @Autowired 
    OrderRepo oRepo;

    @Deprecated
    public Optional<UserEntity> login(String email, String password) {
        return uRepo.findByEmailAndPassword(email, password);
    }

    public boolean signUp(UserEntity user) {
        //todo make email unique
        //handle exception in controller
        if (uRepo.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        uRepo.saveAndFlush(user);
        return true;
    }

    public List<CartEntity> getCart(int uid) {
        return cRepo.findByUserId(uid);
    }

    @Query(value = "select u from UserEntity as u where lower(u.email) = lower(:email)")
    public Optional<UserEntity> findUserByEmail(@Param("email") String email) {
        return uRepo.findByEmail(email);
    }

    public List<CartEntity> getCart(String email) {
        Optional<UserEntity> oUser = uRepo.findByEmail(email);
        if (oUser.isPresent()) {
            UserEntity user = oUser.get();
            return getCart(user.getId());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public boolean addToCart( CartEntity newEntity, String uri )
    {
        ProductEntity product = newEntity.getProduct();
        UserEntity user = newEntity.getUser();

        Optional<CartEntity> cartRecord = cRepo.findByUserIdAndProductId( user.getId(), product.getId() );
        if( cartRecord.isPresent() )
        {
            CartEntity previousEntity = cartRecord.get();

            int newQuantity = 0;
            if( CHECKOUT_CART.equalsIgnoreCase( uri ) )
            {
                newQuantity = newEntity.getQuantity();
            }
            else if( ADD_PRODUCTS.equalsIgnoreCase( uri ) )
            {
                newQuantity = previousEntity.getQuantity() + newEntity.getQuantity();
            }

            if( product.getStock() - newQuantity < 0 )
            {
                return false;
            }
            previousEntity.setQuantity( newQuantity );
            cRepo.saveAndFlush( previousEntity );
            return true;
        }

        if( product.getStock() - newEntity.getQuantity() < 0 )
        {
            return false;
        }
        cRepo.saveAndFlush( newEntity );
        return true;
    }

    public ArrayList<ProductEntity> getAllProducts() {
        return (ArrayList<ProductEntity>) pRepo.findAll();
    }


	public ArrayList<ProductEntity> getProductCategory(String category){
		return (ArrayList<ProductEntity>) pRepo.findByCategory(category);
	}
	
	public ProductEntity getProduct(int pid) {
		return pRepo.findById(pid);
	}
	
	public ArrayList<OrdersEntity> getOrders(int uid){
		return (ArrayList<OrdersEntity>) oRepo.findByUid(uid);
	}
	
	
	public boolean checkout(int uid) {
		ArrayList<CartEntity> cart =(ArrayList<CartEntity>) getCart(uid);
		for(int x=0; x<cart.size(); x+=1){
			if(cart.get(x).getProduct().getStock()-cart.get(x).getQuantity()<0) {
				cRepo.delete(cart.get(x));
				return false;
			}
		}
		for(int x=0; x<cart.size(); x+=1){
			int newStock=cart.get(x).getProduct().getStock()-cart.get(x).getQuantity();
			cart.get(x).getProduct().setStock(newStock);
			pRepo.saveAndFlush(cart.get(x).getProduct());
		}
		cRepo.deleteAllInBatch(cart);
		return true;
	}
	
	 
	
	public String formatTotal(double total) {
		return String.format("$%,.2f", total);
	}
	

	public boolean updateStock(int pid, int stock) {
		ProductEntity update = pRepo.findById(pid);
		if(stock>=0) {
			update.setStock(stock);
			pRepo.saveAndFlush(update);
			return true;
		}
		else {
			return false;
		}
	}


}
