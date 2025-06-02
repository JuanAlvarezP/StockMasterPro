package com.yourcompany.stockmasterpro.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Categoria {
	
	Long id;
	
	String nombre;

	@Column(length=50) @Required
	String descripcion;
	
}
