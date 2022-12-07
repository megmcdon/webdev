package com.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.OrdersEntity;


public interface OrderRepo extends JpaRepository<OrdersEntity, Integer>  {
	Optional<OrdersEntity> findById(int id);
	Optional<OrdersEntity> findByUid(int uid);

}