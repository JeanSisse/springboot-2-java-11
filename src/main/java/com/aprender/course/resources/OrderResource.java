package com.aprender.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprender.course.entities.Order;
import com.aprender.course.services.OrderService;

/**
 * Um controlador REST que responde no caminho (/Orders)
 * 
 * Para informar que esta classe é um recurso web que é implementado
 * por um controlador REST precisamos colocar a anotação (@RestController)
 * 
 * Para nomear o seu recurso utiliza-se a anotação (@RequestMapping("/Orders")) com
 * o nome do caminho do recurso
 * 
 * */

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	// Um end point para acessar os usuários
	// ResponseEntity é um tipo especifico do spring para retornar resposta
	// de requisições web
	//
	// @GetMapping é uma anotação para indicar que o método ResponseEntity responde
	// a requisição do tipo get do http
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}