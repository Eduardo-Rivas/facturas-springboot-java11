package com.edujava.facturas.entities.enums;

public enum OrderStatus {
	PAGADO(1),
	ESPERANDO_PAGO(2),
	ENVIADO(3),
	ENTREGADO(4),
	CANCELADO(5);
	
	private int codigo;
	
	//--Caso especial construtor private--//
	private OrderStatus(int cod) {
		this.codigo = cod;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static OrderStatus strOrderStatus(int cod) {
		for(OrderStatus strEnum : OrderStatus.values()){
			if (strEnum.getCodigo() == cod){
				return strEnum;
			}
		}
		throw new IllegalArgumentException("Código del Enum Invalido...");
	}
	
}
