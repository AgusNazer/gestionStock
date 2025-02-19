package com.gestionstock.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionstock.demo.model.Usuario;
import com.gestionstock.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicioImp implements UsuarioServicio {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServicioImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByDni(Long dni) {
        return usuarioRepository.findByDni(dni);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
//Aquí usamos @Service para que Spring gestione esta clase como un componente de servicio.
//🔹 usuarioRepository es inyectado con @Autowired para acceder a los datos.