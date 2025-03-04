package com.gestionstock.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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


@JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
}
