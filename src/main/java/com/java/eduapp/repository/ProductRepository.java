package com.java.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.eduapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findByName(String name);

}
