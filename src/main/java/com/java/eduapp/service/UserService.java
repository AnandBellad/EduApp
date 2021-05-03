package com.java.eduapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eduapp.entity.User;
import com.java.eduapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User addUser(User user) {
		return repository.save(user);
	}
	
	public User findUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public User findUserByName(String name) {
		return repository.findByUserName(name);
		
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}

}
