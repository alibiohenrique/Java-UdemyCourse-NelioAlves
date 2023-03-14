package com.webservicesjpa.spring.Projetowebservices.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
