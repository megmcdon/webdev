package com.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
	List<ProductEntity> findByCategory(String category);
	ProductEntity findById(int id);

}
