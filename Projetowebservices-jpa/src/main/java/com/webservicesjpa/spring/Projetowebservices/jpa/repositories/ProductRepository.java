package com.webservicesjpa.spring.Projetowebservices.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
