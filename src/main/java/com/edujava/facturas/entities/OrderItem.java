package com.edujava.facturas.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.edujava.facturas.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_Order_Item")
public class OrderItem implements Serializable{
	//--Versionamiento de la Clase--//
	private static final long serialVersionUID = 1L; 
	
	//--Clave Primaria--//
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {

	}
 
	public OrderItem(Order oreder, Product product, Integer quantity, Double price) {
		super();
		id.setOreder(oreder);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	//--Getters y Setter Order--//
	@JsonIgnore
	public Order getOrder() {
		return id.getOreder();
	}
	public void setOrder(Order order) {
		id.setOreder(order);
	}

	//--Getters y Setter Product--//
	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
