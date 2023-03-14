package com.webservicesjpa.spring.Projetowebservices.jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Order;
import com.webservicesjpa.spring.Projetowebservices.jpa.services.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}

}
