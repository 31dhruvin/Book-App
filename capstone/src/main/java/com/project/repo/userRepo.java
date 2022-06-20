package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.User;

public interface userRepo extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
