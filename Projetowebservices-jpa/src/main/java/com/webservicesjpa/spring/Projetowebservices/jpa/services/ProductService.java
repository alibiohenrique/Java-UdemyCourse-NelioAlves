package com.webservicesjpa.spring.Projetowebservices.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Product;
import com.webservicesjpa.spring.Projetowebservices.jpa.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findbyId(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
