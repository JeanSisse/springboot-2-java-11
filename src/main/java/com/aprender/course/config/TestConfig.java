package com.aprender.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprender.course.entities.Order;
import com.aprender.course.entities.User;
import com.aprender.course.repositories.OrderRepository;
import com.aprender.course.repositories.UserRepository;

/**
 * Esta classe é responsável por fazer o data baseseeding (popular db com alguns objetos)
 * 
 * A anotação (@Configuration) informa para Spring que esta é uma classe especifica
 * de configuração 
 * 
 * A anotação (@Profile("test")) informa que esta configuração é especifica para o 
 * perfil de teste 
 * 
 * A anotação (@Autowired) permite ao Spring resolver uma dependência e associar uma
 * instância de uma classe (UserRepository) nesta configuração
 * */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	// Metodo responsável por inicializar alguns objetos quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "990909099", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "121445555", "1234565");
		
		Order o1 = new Order(null, Instant.parse("2021-03-19T20:35:10Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-03-19T21:00:19Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-03-19T22:25:15Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
