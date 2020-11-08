package com.edujava.facturas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edujava.facturas.entities.Order;
import com.edujava.facturas.entities.User;
import com.edujava.facturas.repositories.OrderRepository;
import com.edujava.facturas.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//--Realizamos la inyección de Dependencia--//
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//--Instanciamos la Clase User--//
		User u1 = new User(null, "Edu", "edu@gmail.com", "777", "123");
		User u2 = new User(null, "Nie", "nieves@gmail.com", "888", "456");
		User u3 = new User(null, "Ana", "ana@gmail.com", "999", "789");

		//--Instanciamos la Clase Order--//
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		
		//--Salvamos los Datos de User--//
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	
		//--Salvamos los Datos de Order--//
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
