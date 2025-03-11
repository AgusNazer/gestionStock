package com.gestionstock.demo.service;

import com.gestionstock.demo.DTO.UsuarioDTO;
import com.gestionstock.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    Optional<UsuarioDTO> findById(Long id);

    Optional<UsuarioDTO> findByDni(Long dni);

    Optional<UsuarioDTO> findByEmail(String email);

    List<UsuarioDTO> findAll();

    Usuario save(Usuario usuario);

    void delete(Long id);

    // metodo para crear multiples usuairos en postman para pruebas
    List<Usuario> saveAll(List<Usuario> usuarios);

}
// Esta interfaz define los métodos que voy a implementar en la capa de servicio.

