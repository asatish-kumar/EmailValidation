package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	public UserEntity findByUserEmail(String email); 
}
