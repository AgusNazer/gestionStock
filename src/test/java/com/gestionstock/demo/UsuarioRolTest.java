package com.gestionstock.demo;

import com.gestionstock.demo.model.Rol;
import com.gestionstock.demo.model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.HashSet;

class UsuarioRolTest {

    @Test
    void usuarioDebeTenerRolesUnicos() {
        // Crear un usuario
        Usuario usuario = new Usuario();

        // Crear dos roles (pero con el mismo nombre)
        Rol rol1 = new Rol();
        rol1.setNombre("ADMIN");

        Rol rol2 = new Rol();
        rol2.setNombre("ADMIN"); // Mismo nombre que rol1

        // Agregar roles al usuario
        Set<Rol> roles = new HashSet<>();
        roles.add(rol1);
        roles.add(rol2); // Debería ignorar este porque Set no permite duplicados
        
        usuario.setRoles(roles);

     // Verificar que solo hay un rol
    System.out.println("Roles del usuario: " + usuario.getRoles());
    assertEquals(1, usuario.getRoles().size(), "El usuario debería tener solo un rol único");

     // Imprimir si el test pasa o falla
    if (usuario.getRoles().size() == 1) {
        System.out.println("Test PASADO: El usuario tiene un solo rol único.");
    } else {
        System.out.println("Test FALLADO: El usuario tiene más de un rol.");
    }
}
}