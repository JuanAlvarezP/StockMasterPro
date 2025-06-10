package com.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(members =
    "Datos Generales [numero, fechaOrden, estado;" +
    "fechaEntregaEsperada, fechaEntregaReal, total, observaciones];" +
    "Detalles {detalles}"
)
public class OrdenCompra {
    
    public enum EstadoOrden {
        PENDIENTE, ENVIADA, RECIBIDA, CANCELADA
    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=20) @ReadOnly
    private String numero;
    
    @Required
    private Date fechaOrden = new Date();
    
    private Date fechaEntregaEsperada;
    
    private Date fechaEntregaReal;
    
    @Money @ReadOnly
    private BigDecimal total;
    
    @Column(length=500)
    private String observaciones;
    
    @Enumerated(EnumType.STRING)
    private EstadoOrden estado = EstadoOrden.PENDIENTE;
    
    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL)
    @ListProperties("producto.codigo, producto.nombre, cantidad, precioUnitario, subtotal")
    private Collection<DetalleOrdenCompra> detalles;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Proveedor proveedor;
    
    @PrePersist
    private void generarNumero() {
        this.numero = "OC-" + System.currentTimeMillis();
    }
    
    @PreUpdate
    private void calcularTotal() {
        if (detalles != null) {
            this.total = detalles.stream()
                .map(d -> d.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}