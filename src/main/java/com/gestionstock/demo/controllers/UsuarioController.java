package com.gestionstock.demo.controllers;

import com.gestionstock.demo.DTO.UsuarioDTO;
import com.gestionstock.demo.model.Usuario;
import com.gestionstock.demo.service.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // ✅ Métodos que devuelven DTOs para no exponer datos sensibles
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioServicio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UsuarioDTO> getUsuarioByDni(@PathVariable Long dni) {
        return usuarioServicio.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> getUsuarioByEmail(@PathVariable String email) {
        return usuarioServicio.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // ✅ Métodos que aún necesitan `Usuario` porque trabajan con datos de la BD
    @PostMapping("/multiples")
    public ResponseEntity<List<Usuario>> createUsuarios(@RequestBody List<Usuario> usuarios) {
        List<Usuario> savedUsuarios = usuarioServicio.saveAll(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!id.equals(usuario.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuarioActualizado = usuarioServicio.save(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioServicio.delete(id);
        return ResponseEntity.noContent().build();
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