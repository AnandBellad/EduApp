package com.java.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.eduapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String name);

}
