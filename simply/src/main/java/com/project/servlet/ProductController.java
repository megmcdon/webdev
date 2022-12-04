package com.project.servlet;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.entity.ProductEntity;
import com.project.enums.Categories;


@RestController
public class ProductController {
	
	@GetMapping(value="/products")
	public ResponseEntity<ArrayList<ProductEntity>> getProducts(
			@RequestParam(value="category", required=false) 
			Categories category){
				return null;
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ArrayList<ProductEntity>> getProducts(
			@PathVariable(value="id") 
			int id){
				return null;
		
	}
	

}
