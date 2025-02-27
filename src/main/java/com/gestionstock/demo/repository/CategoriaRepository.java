package com.gestionstock.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Usuario;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // No es necesario crear un método adicional para guardar, puedes usar save()
    // Métodos personalizados pueden agregarse si es necesario
    Optional<Categoria> findByNombre(String nombre);
}
