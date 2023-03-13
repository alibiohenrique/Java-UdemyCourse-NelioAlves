package com.webservicesjpa.spring.Projetowebservices.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.User;
import com.webservicesjpa.spring.Projetowebservices.jpa.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findbyId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
