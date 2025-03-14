package com.gestionstock.demo;

import com.gestionstock.demo.model.Rol;
import com.gestionstock.demo.model.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// import java.util.Set; // estoy usando List
import java.util.ArrayList;
// import java.util.HashSet; // estoy usando List
import java.util.List;

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
        List<Rol> roles = new ArrayList<>();
        roles.add(rol1);
        roles.add(rol2); // Debería ignorar este porque Set no permite duplicados
        
        usuario.setRoles(roles);
        // usuario.setRoles(null);

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