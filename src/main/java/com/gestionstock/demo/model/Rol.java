package com.gestionstock.demo.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // admin, comprador, vendedor

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
}
