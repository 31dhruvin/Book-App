package com.project.service;

import com.project.entity.User;

public interface userServices {
	public User createUser(User user) throws Exception;
	public User getUser(String username);
	public void deleteUser(Long id);
	
}
