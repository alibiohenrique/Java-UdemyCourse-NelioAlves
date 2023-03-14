package com.webservicesjpa.spring.Projetowebservices.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesjpa.spring.Projetowebservices.jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
