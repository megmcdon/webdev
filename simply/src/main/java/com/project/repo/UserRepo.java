package com.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity, Integer>  {
	Optional<UserEntity> findByEmailAndPassword(String email, String password);
	Optional<UserEntity> findByEmail(String email);
}