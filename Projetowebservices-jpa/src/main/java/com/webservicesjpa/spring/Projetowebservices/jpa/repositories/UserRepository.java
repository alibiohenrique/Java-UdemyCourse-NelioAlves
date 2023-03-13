package com.webservicesjpa.spring.Projetowebservices.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.User;

public interface UserRepository	extends JpaRepository<User, Long> {

}
