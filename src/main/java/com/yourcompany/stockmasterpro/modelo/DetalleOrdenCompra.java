package com.yourcompany.stockmasterpro.modelo;

import java.math.*;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class DetalleOrdenCompra {
	Long id;
	Integer cantidad;
	BigDecimal precioUnitario;
	BigDecimal subtotal;

}
