package com.gestionstock.demo.controllers;

import com.gestionstock.demo.DTO.ProductoDTO;
// import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Producto;
import com.gestionstock.demo.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Swagger
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/productos")
// swagger
@Tag(name = "Productos", description = "Operaciones relacionadas con productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve todos los productos")
public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = productoService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto segun su ID", description = "Devuelve un producto basado en su ID")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        Optional<ProductoDTO> producto = productoService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    @Operation(summary = "Crea un producto", description = "Registra un producto en la base de datos")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto existente basado en su ID")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto basado en su ID")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (productoService.eliminarProducto(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener productos por categoría
    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable Long categoriaId) {
        return productoService.obtenerPorCategoria(categoriaId);
    }

}
