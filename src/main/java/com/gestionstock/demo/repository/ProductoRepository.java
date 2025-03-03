package com.gestionstock.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    List<Producto> findByCategoriaId(Long categoriaId);
    
    Optional<Producto> findByNombreAndCategoria(String nombre, Categoria categoria);
    
    Optional<Producto> findByNombre(String nombre);
    
}
