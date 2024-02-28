package com.example.hotels.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotels.dao.UserRepository;
import com.example.hotels.model.User;

public class IuserServiceImpl implements IUserService {
	
	private static final Log log = LogFactory.getLog(IuserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> findAll() {
		Optional<List<User>> listUser = userRepository.findAll();
		return listUser.get();
	}

	@Override
	public User findByUserId(String userId) {
		Optional<User> user = userRepository.findOne(userId);
		return user.get();
	}

	@Override
	public User saveUser(User user) {
		 return userRepository.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		  userRepository.updateUser(user);
		
	}

	@Override
	public void deleteUser(String userId) {
		  userRepository.deleteUser(userId);
		
	}

}
