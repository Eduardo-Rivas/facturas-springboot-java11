package com.edujava.facturas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edujava.facturas.entities.User;
import com.edujava.facturas.repositiries.UserRepositiry;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//--Establecemos la Inyeccion de Dependencia--//
	@Autowired
	private UserRepositiry userRepositiry;

	@Override
	public void run(String... args) throws Exception {
		
		//--Instanciamos la clase User--//
		User u1 = new User(null, "Eduardo Rivas", "eduardo@gmail.com", "8888888", "123");
		User u2 = new User(null, "Nieves Rodriguez", "nieves@gmail.com", "7777777", "456");
		
		//--Salva la Data Instanciada--//
		userRepositiry.saveAll(Arrays.asList(u1,u2));
	}
	
}
