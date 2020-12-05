package com.edujava.facturas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edujava.facturas.entities.Category;
import com.edujava.facturas.entities.Order;
import com.edujava.facturas.entities.Product;
import com.edujava.facturas.entities.User;
import com.edujava.facturas.entities.enums.OrderStatus;
import com.edujava.facturas.repositories.CategoryRepository;
import com.edujava.facturas.repositories.OrderRepository;
import com.edujava.facturas.repositories.ProductRepository;
import com.edujava.facturas.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//--Realizamos la inyección de Dependencia--//
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
    private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {

		//--Instanciamos las Categorias de Productos--//
		Category cat1 = new Category(null, "Electronicos");
		Category cat2 = new Category(null, "Libros");
		Category cat3 = new Category(null, "Computadoras");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null,"Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product	p5 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		 
		//--Salvamos los Datos de Categorias--//
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//--Instanciamos la Clase User--//
		User u1 = new User(null, "Edu", "edu@gmail.com", "777", "123");
		User u2 = new User(null, "Nie", "nieves@gmail.com", "888", "456");
		User u3 = new User(null, "Ana", "ana@gmail.com", "999", "789");

		//--Instanciamos la Clase Order--//
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAGADO, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.ESPERANDO_PAGO, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.ESPERANDO_PAGO, u1);

		
		//--Salvamos los Datos de User--//
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	
		//--Salvamos los Datos de Order--//
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
