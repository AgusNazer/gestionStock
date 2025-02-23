package com.gestionstock.demo.controllers;

import com.gestionstock.demo.model.Usuario;
import com.gestionstock.demo.service.UsuarioServicio;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    // @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioServicio.findById(id);
    }

    @GetMapping("/dni/{dni}")
    public Optional<Usuario> getUsuarioByDni(@PathVariable Long dni) {
        return usuarioServicio.findByDni(dni);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> getUsuarioByEmail(@PathVariable String email) {
        return usuarioServicio.findByEmail(email);
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioServicio.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        usuarioServicio.save(usuario);
        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);  // Responde con mensaje y código de estado 201
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioServicio.delete(id);
    }
}

//@RestController indica que esta clase manejará peticiones HTTP.
// @RequestMapping("/usuarios") define la ruta base.
// Métodos @GetMapping, @PostMapping, y @DeleteMapping exponen endpoints REST.

// Resumen de hoy
// Resumen
//  UsuarioRepository: Interfaz que extiende JpaRepository, con métodos como findByDni().
//  UsuarioService: Define los métodos de negocio.
//  UsuarioServiceImpl: Implementa la lógica del servicio.
//  UsuarioController: Expone una API REST para manejar Usuario.

// Con esto, ya tienes una estructura limpia y escalable para manejar Usuario en tu sistema de gestión de stock. 🚀