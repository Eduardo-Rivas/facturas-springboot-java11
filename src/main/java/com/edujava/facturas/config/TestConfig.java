package com.edujava.facturas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edujava.facturas.entities.User;
import com.edujava.facturas.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//--Realizamos la inyección de Dependencia--//
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//--Instanciamos la Clase User--//
		User u1 = new User(null, "Eduardo", "eduardo@gmail.com", "777", "123");
		User u2 = new User(null, "Nieves", "nieves@gmail.com", "888", "456");
		
		//--Salvamos los Datos--//
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
}
