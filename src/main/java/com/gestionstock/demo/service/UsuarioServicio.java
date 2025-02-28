package com.gestionstock.demo.service;

import com.gestionstock.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByDni(Long dni);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    void delete(Long id);
}
// Esta interfaz define los métodos que voy a implementar en la capa de servicio.

