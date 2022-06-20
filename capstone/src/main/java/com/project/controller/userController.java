package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.service.userServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class userController {
	@Autowired
	private userServices userservices;
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		return this.userservices.createUser(user);
		
		
	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userservices.getUser(username);	
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		this.userservices.deleteUser(id);
		
	}
	

}
