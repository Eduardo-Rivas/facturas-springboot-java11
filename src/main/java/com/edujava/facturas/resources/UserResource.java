package com.edujava.facturas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edujava.facturas.entities.User;
 
@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Luis", "luis@gmail.com", "7777777", "123");
		return ResponseEntity.ok().body(u);
	}
	
}
