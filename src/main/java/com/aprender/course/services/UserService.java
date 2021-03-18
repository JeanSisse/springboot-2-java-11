package com.aprender.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprender.course.entities.User;
import com.aprender.course.repositories.UserRepository;


/**
 * 
 * A anotação @Service te permite registrar um serviço na camada de serviço
 * 
 **/
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
