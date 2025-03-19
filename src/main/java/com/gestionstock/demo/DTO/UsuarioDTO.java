package com.gestionstock.demo.DTO;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
    @NotNull(message = "El DNI no puede ser nulo")
    private Long dni;
    // private Boolean esAdmin;
    // private List<String> roles; // Si un usuario tiene múltiples roles

    public UsuarioDTO(String nombre, String apellido, String email, Integer edad, Long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.dni = dni;
;
        // this.esAdmin = esAdmin;
        // this.roles = roles;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public Long getDni() { return dni; }
    public void setDni(Long dni) { this.dni = dni; }

    // public Boolean getEsAdmin() { return esAdmin; }
    // public void setEsAdmin(Boolean esAdmin) { this.esAdmin = esAdmin; }

    // public List<String> getRoles() { return roles; }
    // public void setRoles(List<String> roles) { this.roles = roles; }
}

// Corregir la data que mando al ciente, no mandar si es admin o no, ni tampoco
// el rol del cliente.