package com.project.dbservice;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartEntity;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;
import com.project.repo.CartRepo;
import com.project.repo.ProductRepo;
import com.project.repo.UserRepo;

@Service
public class DBAccessService {
	
	@Autowired CartRepo cRepo;
	@Autowired UserRepo uRepo;
	@Autowired ProductRepo pRepo;
	
	public Optional<UserEntity> login(String email, String password){
		return uRepo.findByEmailAndPassword(email, password);
	}
	
	public boolean signUp(UserEntity user) {
		if(uRepo.findByEmail(user.getEmail()).isPresent()) {
			return false;
		}
		uRepo.saveAndFlush(user);
		return true;
	}
	
	public ArrayList<CartEntity> getCart(int uid){
		return (ArrayList<CartEntity>)cRepo.findByUid(uid);
	}
	
	public boolean addToCart(CartEntity cart) {
		ProductEntity product = pRepo.findById(cart.getPid());
		pRepo.saveAndFlush(product);
		Optional<CartEntity> cartRecord = cRepo.findByUidAndPid(cart.getUid(), cart.getPid());
		//increase number in cart if already in cart
		if(cartRecord.isPresent()) {
			cart.setQuantity(cartRecord.get().getQuantity()+cart.getQuantity());
		}
		if(product.getStock()-cart.getQuantity()<0) {
			return false;
		}
		else {
			cRepo.saveAndFlush(cart);
			return true;
		}
		
	}
	
	public ArrayList<ProductEntity> getAllProducts(){
		return (ArrayList<ProductEntity>) pRepo.findAll();
	}
	
	public ArrayList<ProductEntity> getProductCategory(String category){
		return (ArrayList<ProductEntity>) pRepo.findByCategory(category);
	}
	
	public ProductEntity getProduct(int pid) {
		return pRepo.findById(pid);
	}

}
