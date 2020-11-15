package com.edujava.facturas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujava.facturas.entities.Category;
import com.edujava.facturas.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repositiry;
	
	public List<Category> findAll(){
		return repositiry.findAll();
	}
	 
	public Category findById(Long id) {
		Optional<Category> obj = repositiry.findById(id);
		return obj.get();
	}
	
}
