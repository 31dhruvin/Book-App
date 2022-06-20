package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.entity.User;
import com.project.service.userServices;

@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner{
	@Autowired
	private userServices userservices;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
	

}
