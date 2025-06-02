package com.yourcompany.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class Producto {
	
	Long id;
	String codigo;
	String nombre;
	String descripcion;
	BigDecimal precio;
	Integer stockActual;
	Integer stockMinimo;
	Date fechaCreacion;
	Date fechaActualizacion;

}
