package com.aprender.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprender.course.entities.Order;
import com.aprender.course.repositories.OrderRepository;


/**
 * 
 * A anotação @Service te permite registrar um serviço na camada de serviço
 * 
 **/
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
