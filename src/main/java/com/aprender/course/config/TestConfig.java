package com.aprender.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprender.course.entities.User;
import com.aprender.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "990909099", "12345");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "121445555", "1234565");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
