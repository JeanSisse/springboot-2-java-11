package com.aprender.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprender.course.entities.Category;
import com.aprender.course.entities.Order;
import com.aprender.course.entities.Product;
import com.aprender.course.entities.User;
import com.aprender.course.entities.enums.OrderStatus;
import com.aprender.course.repositories.CategoryRepository;
import com.aprender.course.repositories.OrderRepository;
import com.aprender.course.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	// Metodo responsável por inicializar alguns objetos quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet", 12.00, "");
		Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit amet", 12.00, "");
		Product p3 = new Product(null, "Mackbook Pro", "Lorem ipsum dolor sit amet", 12.00, "");
		Product p4 = new Product(null, "PC Gamer", "Lorem ipsum dolor sit amet", 12.00, "");
		Product p5 = new Product(null, "Rails for Dummies", "Lorem ipsum dolor sit amet", 12.00, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "990909099", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "121445555", "1234565");
		
		Order o1 = new Order(null, Instant.parse("2021-03-19T20:35:10Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-03-19T21:00:19Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-03-19T22:25:15Z"), OrderStatus.DELIVERED, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
