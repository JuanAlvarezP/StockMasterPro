package com.yourcompany.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class OrdenCompra {
	
	public enum EstadoOrden{
		PENDIENTE,
		ENVIADA,
		RECIBIDA,
		CANCELADA
	}
	
	Long id;
	String numero;
	Date fechaOrden;
	Date fechaEntregaEsperada;
	Date fechaEntregaReal;
	BigDecimal total;
	String observaciones;
	EstadoOrden estado;

}
