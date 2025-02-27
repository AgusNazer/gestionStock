package com.gestionstock.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", nullable = false)
    private Categoria categoria; // Relación con la clase Categoria

}
