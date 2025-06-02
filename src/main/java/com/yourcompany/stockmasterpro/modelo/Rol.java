package com.yourcompany.stockmasterpro.modelo;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class Rol {
	Long id;
	String nombre;
	String descripcion;

}
