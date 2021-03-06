package com.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.config.JwtUtils;
import com.project.entity.JwtRequest;
import com.project.entity.JwtResponse;
import com.project.entity.User;
import com.project.service.userDetailServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private userDetailServiceImpl userdetailServiceImpl;
	
	@Autowired
	private JwtUtils jwtutils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("user not found");
		}
		UserDetails userDetails = this.userdetailServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String s = this.jwtutils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(s)); 
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		}catch(DisabledException e) {
			throw new Exception("user disabled" + e.getMessage());
			
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials" + e.getMessage());
		}
		
	}
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userdetailServiceImpl.loadUserByUsername(principal.getName()));
	}

}
