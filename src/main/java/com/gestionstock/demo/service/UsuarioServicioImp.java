package com.gestionstock.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionstock.demo.DTO.UsuarioDTO;
import com.gestionstock.demo.mapper.UsuarioMapper;
import com.gestionstock.demo.model.Usuario;
import com.gestionstock.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicioImp implements UsuarioServicio {
    
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServicioImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ✅ Métodos que devuelven DTOs
    @Override
    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO); // Convertimos a DTO
    }
    
    @Override
    public Optional<UsuarioDTO> findByDni(Long dni) {
        return usuarioRepository.findByDni(dni)
                .map(UsuarioMapper::toDTO);
    }
    
    @Override
    public Optional<UsuarioDTO> findByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(UsuarioMapper::toDTO);
    }
    
    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.toDTOList(usuarios); // Convertimos lista a DTOs
    }
    
    // ✅ Métodos que usan la entidad Usuario porque trabajan con datos de la BD
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> saveAll(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}

//Aquí usamos @Service para que Spring gestione esta clase como un componente de servicio.
//🔹 usuarioRepository es inyectado con @Autowired para acceder a los datos.