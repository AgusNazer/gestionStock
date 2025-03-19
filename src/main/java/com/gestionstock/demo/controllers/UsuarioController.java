package com.gestionstock.demo.controllers;

import com.gestionstock.demo.DTO.UsuarioDTO;
import com.gestionstock.demo.model.Usuario;
import com.gestionstock.demo.service.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Swagger
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173") // mi frontend
@RestController
@RequestMapping("/usuarios")
// swagger doc
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // Metodos que devuelven DTOs para no exponer datos sensibles

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario basado en su ID")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioServicio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dni}")
    @Operation(summary = "Obtener usuario por DNI", description = "Devuelve un usuario basado en su número de DNI")
    public ResponseEntity<UsuarioDTO> getUsuarioByDni(@PathVariable Long dni) {
        return usuarioServicio.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Obtener usuario por email", description = "Devuelve un usuario basado en su dirección de email")
    public ResponseEntity<UsuarioDTO> getUsuarioByEmail(@PathVariable String email) {
        return usuarioServicio.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios registrados")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // Metodos que aún necesitan `Usuario` porque trabajan con datos de la BD
    // Método para crear múltiples usuarios
    @PostMapping("/multiples")
    @Operation(summary = "Crear múltiples usuarios", description = "Registra una lista de usuarios en la base de datos")
    public ResponseEntity<List<UsuarioDTO>> createUsuarios(@RequestBody @Valid List<UsuarioDTO> usuariosDTO) {
        // Convertir los DTOs a entidades Usuario
        List<Usuario> usuarios = usuariosDTO.stream()
                .map(dto -> new Usuario(dto.getNombre(), dto.getApellido(), dto.getEmail(), dto.getEdad(), dto.getDni()))
                .collect(Collectors.toList());
    
        // Guardar los usuarios en la base de datos
        List<Usuario> savedUsuarios = usuarioServicio.saveAll(usuarios);
    
        // Convertir los usuarios guardados a DTOs (sin enviar información sensible)
        List<UsuarioDTO> savedUsuariosDTO = savedUsuarios.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getEdad(),
                        usuario.getDni() // <-- Se incluye dni
                ))
                .collect(Collectors.toList());
    
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuariosDTO);
    }
    

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente basado en su ID")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            // Validación para asegurarse de que el DNI no sea nulo
            if (usuarioDTO.getDni() == null) {
                return ResponseEntity.badRequest().build();
            }
    
            // Crear un objeto Usuario con los datos del DTO
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setEdad(usuarioDTO.getEdad());
            usuario.setDni(usuarioDTO.getDni());
    
            // Guardamos el usuario actualizado
            Usuario usuarioActualizado = usuarioServicio.save(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (Exception e) {
            // Log de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario basado en su ID")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

}
