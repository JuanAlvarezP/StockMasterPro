package com.yourcompany.stockmasterpro.modelo;

import java.util.*;

import javax.persistence.*;

import lombok.*;


@Entity @Getter @Setter
public class MovimientoStock {
	
	public enum TipoMovimiento{
		ENTRADA,
		SALIDA,
		AJUSTE,
		COMPRA
	} 
	
	Long id;
	TipoMovimiento tipo;
	Integer cantidad;
	Date fecha;
	String numeroDocumento;
	String observaciones;
	

}
