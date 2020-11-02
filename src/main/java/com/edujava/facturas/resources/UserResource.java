package com.edujava.facturas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edujava.facturas.entities.User;
import com.edujava.facturas.services.UserService;
 
@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service; 
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
