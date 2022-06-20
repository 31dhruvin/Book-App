package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repo.userRepo;

@Service
public class userServiceIImpl implements userServices{
	@Autowired
	private userRepo userrepo;
	
	@Override
	public User createUser(User user) throws Exception {
		User demo = this.userrepo.findByUsername(user.getUsername());
		if(demo!=null) {
			System.out.println("User already exist");
			throw new Exception("User already present");
			
		}
		return userrepo.save(user);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userrepo.findByUsername(username);
	}

	@Override
	public void deleteUser(Long id) {
		this.userrepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
