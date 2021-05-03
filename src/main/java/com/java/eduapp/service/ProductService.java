package com.java.eduapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eduapp.entity.Product;
import com.java.eduapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> product) {
		return repository.saveAll(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product deleted" + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setId(product.getId());
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());

		return repository.save(existingProduct);
	}
}
