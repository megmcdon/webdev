package com.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, Integer>  {
	List<CartEntity> findByUid(int uid);
	Optional<CartEntity> findByUidAndPid(int uid, int pid);
}
