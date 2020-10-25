package com.edujava.facturas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujava.facturas.entities.User;
import com.edujava.facturas.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repositiry;
	
	public List<User> findAll(){
		return repositiry.findAll();
	}
	 
	public User findById(Long id) {
		Optional<User> obj = repositiry.findById(id);
		return obj.get();
	}
	
}
