package com.webservicesjpa.spring.Projetowebservices.jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Product;
import com.webservicesjpa.spring.Projetowebservices.jpa.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}

}
