package com.aprender.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprender.course.entities.Category;
import com.aprender.course.repositories.CategoryRepository;


/**
 * 
 * A anotação @Service te permite registrar um serviço na camada de serviço
 * 
 **/
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
