package com.gestionstock.demo.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProductoDTO {

    // private Long id;
    @Schema(example = "Teclado Keychron")
    private String nombre;
    @Schema(example = "Teclado mecánico Keychron K8 Pro")
    private String descripcion;

    @Schema(example = "280")
    private Double precio;

    public ProductoDTO(String nombre, String description, Double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
