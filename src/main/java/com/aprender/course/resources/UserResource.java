package com.aprender.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aprender.course.entities.User;
import com.aprender.course.services.UserService;

/**
 * Um controlador REST que responde no caminho (/users)
 * 
 * Para informar que esta classe é um recurso web que é implementado
 * por um controlador REST precisamos colocar a anotação (@RestController)
 * 
 * Para nomear o seu recurso utiliza-se a anotação (@RequestMapping("/users")) com
 * o nome do caminho do recurso
 * 
 * */

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	// Um end point para acessar os usuários
	// ResponseEntity é um tipo especifico do spring para retornar resposta
	// de requisições web
	//
	// @GetMapping é uma anotação para indicar que o método ResponseEntity responde
	// a requisição do tipo get do http
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * End-point para inserir recurso no banco de dados
	 * 
	 * Para descerializar o objeto que vai chegar em formato Json 
	 * no request usa-se anotação @RequestBody
	 * */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId())
					.toUri(); 
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}