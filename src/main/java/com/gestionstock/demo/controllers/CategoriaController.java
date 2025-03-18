package com.gestionstock.demo.controllers;

import com.gestionstock.demo.DTO.CategoriaDTO;
import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Swagger
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/categorias")
// swagger doc
@Tag(name = "Categorias", description = "Operaciones relacionadas con categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías
    @GetMapping
    @Operation(summary = "Obtener todas las categorias", description = "Devuelve una lista de todos las categorias registradas")
    public List<CategoriaDTO> obtenerCategorias() {
        return categoriaService.obtenerTodas();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener categoria por ID", description = "Devuelve una categoria basado en su ID")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    @Operation(summary = "Crea una categoria", description = "Registra una categoria en la base de datos")
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    // Actualizar una categoría
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar categoria", description = "Actualiza una categoria existente basada en su ID")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.actualizarCategoria(id, categoria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoria", description = "Elimina una categoria basada en su ID")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriaService.eliminarCategoria(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
