package com.project.tests;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dbservice.DBAccessService;
import com.project.entity.CartEntity;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;

@RestController
@RequestMapping("/test")
public class SpringTests {
	
	@Autowired
	DBAccessService db;
	
	@GetMapping("/go")
    public String runTest() {
    	return "HELLO";
    }
	
	@GetMapping("/product")
	public ArrayList<ProductEntity> getProducts(){
		return db.getAllProducts();	
	}



}
