package com.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, Integer>  {
	List<CartEntity> findByU_id(int u_id);
	Optional<CartEntity> findByU_idAndP_id(int u_id, int p_id);
}
