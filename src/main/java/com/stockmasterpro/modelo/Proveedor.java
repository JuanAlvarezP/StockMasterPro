package com.stockmasterpro.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(members = 
    "Datos Generales [codigo, nombre, contacto;" +
    "telefono, email, direccion, fechaRegistro];" +
    "Productos suministrados {productos}"
)
public class Proveedor {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=20) @Required
    private String codigo;
    
    @Column(length=100) @Required
    private String nombre;
    
    @Column(length=100)
    private String contacto;
    
    @Column(length=20)
    private String telefono;
    
    @Email
    private String email;
    
    @Column(length=200)
    private String direccion;
    
    @ReadOnly
    private Date fechaRegistro = new Date();
    
    @OneToMany(mappedBy = "proveedorPrincipal")
    @ListProperties("codigo, nombre, precio")
    private Collection<Producto> productos;
}