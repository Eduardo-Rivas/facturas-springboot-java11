package edu.javaproweb.facturas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.javaproweb.facturas.entities.User;
 
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findall(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "abc123");
		return ResponseEntity.ok().body(u);
	}
}
