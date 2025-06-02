package com.yourcompany.stockmasterpro.modelo;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class Proveedor {
	Long id;
	String codigo;
	String nombre;
	String contacto;
	String telefono;
	String email;
	String direccion;
	Date fechaRegistro;

}
