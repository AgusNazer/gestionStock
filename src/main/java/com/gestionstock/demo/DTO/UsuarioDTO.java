//  Evitan exponer directamente las entidades del modelo
//  Permiten manejar datos de forma estructurada y optimizada
//  Reducen problemas de acoplamiento entre capas

package com.gestionstock.demo.DTO;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String rol; //admin, empleado, proveedor
}

