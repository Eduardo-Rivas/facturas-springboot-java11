package com.edujava.facturas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edujava.facturas.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
