package com.gestionstock.demo.DTO;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Long categoriaId; // relacionarlo con CategoriaDTO
    // private String categoriaNombre;
}
