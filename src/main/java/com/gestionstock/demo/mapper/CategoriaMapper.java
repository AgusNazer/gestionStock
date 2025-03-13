package com.gestionstock.demo.mapper;

import com.gestionstock.demo.DTO.CategoriaDTO;
import com.gestionstock.demo.model.Categoria;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMapper {

    // Convierte una entidad Categoria a un DTO
    public static CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(
            // categoria.getId(),
            categoria.getNombre()
        );
    }

    // Convierte una lista de Categorias a una lista de DTOs
    public static List<CategoriaDTO> toDTOList(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaMapper::toDTO).collect(Collectors.toList());
    }
}
