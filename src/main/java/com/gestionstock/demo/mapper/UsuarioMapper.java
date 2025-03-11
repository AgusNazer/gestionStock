package com.gestionstock.demo.mapper;

import com.gestionstock.demo.DTO.UsuarioDTO;
import com.gestionstock.demo.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    // Convierte una entidad Usuario en un DTO
    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getNombre(),
            usuario.getApellido(),
            usuario.getEmail(),
            usuario.getEdad(),
            usuario.getEsAdmin(),
            usuario.getRoles().stream().map(rol -> rol.getNombre()).collect(Collectors.toList()) //Convertir roles
        );
    }

    // Convierte una lista de entidades Usuario en una lista de DTOs
    public static List<UsuarioDTO> toDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }
}
