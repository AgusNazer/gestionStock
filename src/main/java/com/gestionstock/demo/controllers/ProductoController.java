package com.gestionstock.demo.controllers;

import com.gestionstock.demo.DTO.ProductoDTO;
import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Producto;
import com.gestionstock.demo.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping
public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = productoService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        Optional<ProductoDTO> producto = productoService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
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
