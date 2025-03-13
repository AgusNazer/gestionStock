package com.gestionstock.demo.DTO;

public class CategoriaDTO {
    // private Long id;
    private String nombre;


    public CategoriaDTO(String nombre){
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
