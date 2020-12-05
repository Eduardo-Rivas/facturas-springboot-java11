package com.edujava.facturas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edujava.facturas.entities.Product;
import com.edujava.facturas.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repositiry;
	
	public List<Product> findAll(){
		return repositiry.findAll();
	}
	 
	public Product findById(Long id) {
		Optional<Product> obj = repositiry.findById(id);
		return obj.get();
	}
	
}
