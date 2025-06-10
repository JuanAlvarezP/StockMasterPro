package com.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Venta {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=10) @ReadOnly
    private String numero;
    
    @Required
    private Date fecha = new Date();
    
    @ManyToOne(fetch = FetchType.LAZY) @Required
    @DescriptionsList
    private Cliente cliente;
    
    @Money @ReadOnly
    private BigDecimal total = BigDecimal.ZERO;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @ListProperties("producto.codigo, producto.nombre, cantidad, precioUnitario, subtotal")
    private Collection<DetalleVenta> detalles = new ArrayList<>();
    
    @PrePersist
    private void generarNumero() {
        this.numero = "V-" + System.currentTimeMillis() % 10000;
    }
    
    @PreUpdate
    private void calcularTotal() {
        this.total = detalles.stream()
            .map(DetalleVenta::getSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    // Método helper para pruebas
    public void agregarDetalle(Producto producto, int cantidad) {
        DetalleVenta detalle = new DetalleVenta();
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setVenta(this);
        detalles.add(detalle);
    }
}