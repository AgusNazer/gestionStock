package com.gestionstock.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private long dni;

    private Boolean esAdmin;
    @JsonManagedReference

    // un usuario puede registrar varios movimientos de stock
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimientoStock> movimientos = new ArrayList<>();

    // cada usuario puede tener varios roles / un rol puede ser asignado a varios usuarios
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USUARIO_ROL",
        joinColumns = @JoinColumn(name = "USUARIO_ID"),
        inverseJoinColumns = @JoinColumn(name = "ROL_ID")
    )
    private Set<Rol> roles;
}
