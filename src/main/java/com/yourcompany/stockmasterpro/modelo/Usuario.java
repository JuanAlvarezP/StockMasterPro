package com.yourcompany.stockmasterpro.modelo;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class Usuario {
	
	Long id;
	String username;
	String password;
	String nombre;
	String apellido;
	String email;
	Date fechaCreacion;

}
