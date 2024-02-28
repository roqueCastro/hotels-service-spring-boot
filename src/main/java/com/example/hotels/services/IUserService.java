package com.example.hotels.services;

import java.util.List;

import com.example.hotels.model.User;

public interface IUserService {
	
	  List<User> findAll();
		
	  User findByUserId(String userId);
	  
	  User saveUser(User user);
	  void updateUser(User user);
	  void deleteUser(String userId);

}
