//  Evitan exponer directamente las entidades del modelo
//  Permiten manejar datos de forma estructurada y optimizada
//  Reducen problemas de acoplamiento entre capas

package com.gestionstock.demo.DTO;

public class UsuarioDTO {
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
    private Boolean esAdmin;
    private String rol; //admin, empleado, proveedor
}

// utuilzar el usuario dto para devoler solo los datos necessarios y no exponer datos que no queremos, como id or ejemplo., 