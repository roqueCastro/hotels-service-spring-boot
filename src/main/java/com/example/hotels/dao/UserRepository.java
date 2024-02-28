package com.example.hotels.dao;

import java.util.List;
import java.util.Optional;

import com.example.hotels.model.User;

public interface UserRepository {
	  Optional<List<User>>  findAll();
	  Optional<User>  findOne(String userId);

	  
	  public User saveUser(User user);
	  
	  public void updateUser(User user);
	  
	  public void deleteUser(String userId);
}
