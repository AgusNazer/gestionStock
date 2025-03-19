package com.gestionstock.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;

    @Column(unique = true, nullable = false, length = 10)
    private Long dni;

    private Boolean esAdmin;
    @JsonManagedReference

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimientoStock> movimientos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USUARIO_ROL",
        joinColumns = @JoinColumn(name = "USUARIO_ID"),
        inverseJoinColumns = @JoinColumn(name = "ROL_ID")
    )
    private List<Rol> roles;

    // Constructor con los parámetros necesarios para el DTO
    public Usuario(String nombre, String apellido, String email, Integer edad, Long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.dni = dni;
    }

    // Constructor sin parámetros (necesario para JPA)
    public Usuario() {}

    // Los métodos addRol() pueden ser necesarios si decides utilizarlos para manejar roles de usuario
    // public void addRol(Rol rol) {
    //     this.roles.add(rol);
    //     rol.getUsuarios().add(this); 
    // }
}
