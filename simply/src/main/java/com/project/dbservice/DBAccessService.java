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
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Service
public class DBAccessService {

    @Autowired
    CartRepo cRepo;
    @Autowired
    UserRepo uRepo;
    @Autowired
    ProductRepo pRepo;

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

    public boolean addToCart(CartEntity cart) {
        ProductEntity product = cart.getProduct();
        UserEntity user = cart.getUser();
        Optional<CartEntity> cartRecord = cRepo.findByUserIdAndProductId(user.getId(), product.getId());
        //increase number in cart if already in cart
        if (cartRecord.isPresent()) {
            cart.setQuantity(cartRecord.get().getQuantity() + cart.getQuantity());
        }
        if (product.getStock() - cart.getQuantity() < 0) {
            return false;
        } else {
            cRepo.saveAndFlush(cart);
            return true;
        }

    }

    public ArrayList<ProductEntity> getAllProducts() {
        return (ArrayList<ProductEntity>) pRepo.findAll();
    }

    public List<ProductEntity> getProductCategory(String category) {
        return pRepo.findByCategory(category);
    }

    public ProductEntity getProduct(int pid) {
        return pRepo.findById(pid);
    }

}
