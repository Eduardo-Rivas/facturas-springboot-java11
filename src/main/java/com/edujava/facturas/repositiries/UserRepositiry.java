package com.edujava.facturas.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edujava.facturas.entities.User;

public interface UserRepositiry extends JpaRepository<User, Long> {
	
}
