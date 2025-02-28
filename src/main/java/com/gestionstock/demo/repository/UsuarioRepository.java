package com.gestionstock.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionstock.demo.model.Usuario;



    @Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
       // Buscar un usuario por DNI
    Optional<Usuario> findByDni(Long dni);

    // Buscar un usuario por email
    Optional<Usuario> findByEmail(String email);

    // Verificar si un usuario con un DNI específico existe
    boolean existsByDni(Long dni);

    // Optional<Usuario> updateUsuario(Long id, Usuario usuario);

    //Spring Data JPA generará automáticamente la implementación de estos métodos basándose en el nombre.


}


