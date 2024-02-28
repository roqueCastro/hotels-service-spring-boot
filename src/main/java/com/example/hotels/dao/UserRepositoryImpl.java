package com.example.hotels.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.example.hotels.model.User;

public class UserRepositoryImpl implements UserRepository {
	
	private final MongoOperations mongoOperations;
	
	@Autowired
	public UserRepositoryImpl(MongoOperations mongoOperations) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }

	
	public Optional<List<User>> findAll() {
		List<User> users = this.mongoOperations.find(new Query(), User.class);
		Optional<List<User>> user_list = Optional.ofNullable(users);
		return user_list;
	}
	
	public Optional<User> findOne(String userId) {
        User d = this.mongoOperations.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
        Optional<User> user = Optional.ofNullable(d);
        return user;
    }

	@Override
	public User saveUser(User user) {
	  this.mongoOperations.save(user);
	  return this.findOne(user.getUserId()).get();
	}

	@Override
	public void updateUser(User user) {
		this.mongoOperations.save(user);
		
	}

	@Override
	public void deleteUser(String userId) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("userId").is(userId)), User.class);
		
	}

}
