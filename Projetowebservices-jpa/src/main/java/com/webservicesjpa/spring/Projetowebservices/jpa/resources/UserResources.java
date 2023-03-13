package com.webservicesjpa.spring.Projetowebservices.jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "51993133353", "okok123456");
		return ResponseEntity.ok().body(u);
	}
}
