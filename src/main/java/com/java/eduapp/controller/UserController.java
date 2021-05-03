package com.java.eduapp.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.eduapp.entity.User;
import com.java.eduapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) throws Exception {
		
		if(user.getRole().isBlank()) {
			throw new Exception("Role Cannot be EMPTY");
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(System.currentTimeMillis());  
		user.setCreatedAt(formatter.format(date));
		return userService.addUser(user);
		
	}
	
	@GetMapping("/getuser/{name}")
	public User getUser(@PathVariable String name) {
		return userService.findUserByName(name);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws Exception {
		User eu = userService.findUserById(user.getId());
		System.out.print("eu:::::::::" + eu);
		
		  if(eu == null) { 
			  throw new Exception("User not found for ID" + user.getId());
		  }
		 
		eu.setFirstName(user.getFirstName());
		eu.setLastName(user.getLastName());
		eu.setEmailId(user.getEmailId());
		eu.setGender(user.getGender());
		eu.setMobileNumber(user.getMobileNumber());
		return userService.updateUser(user);
	}

}
