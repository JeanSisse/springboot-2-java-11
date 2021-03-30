package com.aprender.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprender.course.entities.Category;
import com.aprender.course.entities.Order;
import com.aprender.course.entities.OrderItem;
import com.aprender.course.entities.Product;
import com.aprender.course.entities.User;
import com.aprender.course.entities.enums.OrderStatus;
import com.aprender.course.repositories.CategoryRepository;
import com.aprender.course.repositories.OrderItemRepository;
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
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	// Metodo responsável por inicializar alguns objetos quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet", 12.00, "");
		Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit amet", 1200.00, "");
		Product p3 = new Product(null, "Mackbook Pro", "Lorem ipsum dolor sit amet", 12000.00, "");
		Product p4 = new Product(null, "PC Gamer", "Lorem ipsum dolor sit amet", 2000.00, "");
		Product p5 = new Product(null, "Rails for Dummies", "Lorem ipsum dolor sit amet", 125.00, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// Mapeando do produto para categoria
//		p1.getCategories().add(cat2);
//		p2.getCategories().add(cat1);
//		p2.getCategories().add(cat3);
//		p3.getCategories().add(cat3);
//		p4.getCategories().add(cat3);
//		p5.getCategories().add(cat2);
		
		// Mapeando da categoria para produto
		cat1.getProducts().add(p2);
		cat2.getProducts().add(p1);
		cat2.getProducts().add(p5);
		cat3.getProducts().add(p2);
		cat3.getProducts().add(p3);
		cat3.getProducts().add(p4);
		
//		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "990909099", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "121445555", "1234565");
		
		Order o1 = new Order(null, Instant.parse("2021-03-19T20:35:10Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-03-19T21:00:19Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-03-19T22:25:15Z"), OrderStatus.DELIVERED, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}
}
