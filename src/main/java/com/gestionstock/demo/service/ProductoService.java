package com.gestionstock.demo.service;

import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Producto;
import com.gestionstock.demo.repository.CategoriaRepository;
import com.gestionstock.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;



    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("Debe especificar una categoría");
        }
    
        Categoria categoria = producto.getCategoria();
    
        if (categoria.getId() == null) {
            String nombreCategoria = categoria.getNombre();
    
            // Buscar si la categoría ya existe por nombre y asignarla
            categoria = categoriaRepository.findByNombre(nombreCategoria)
                .orElseGet(() -> {
                    Categoria nuevaCategoria = new Categoria();
                    nuevaCategoria.setNombre(nombreCategoria);
                    return categoriaRepository.save(nuevaCategoria);
                });
        } else {
            // Verificar si el ID existe en la base de datos
            categoria = categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new IllegalArgumentException("La categoría especificada no existe"));
        }
    
        producto.setCategoria(categoria);
    
        // Verificar si el producto ya existe por nombre y categoría antes de guardarlo
        Optional<Producto> productoExistente = productoRepository.findByNombreAndCategoria(producto.getNombre(), categoria);
        if (productoExistente.isPresent()) {
            return productoExistente.get(); // Retornar el producto existente en lugar de crear uno nuevo
        }
    
        return productoRepository.save(producto);
    }
    


    public Optional<Producto> actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(nuevoProducto.getNombre());
            producto.setDescripcion(nuevoProducto.getDescripcion());
            producto.setPrecio(nuevoProducto.getPrecio());
            producto.setStock(nuevoProducto.getStock());
            producto.setCategoria(nuevoProducto.getCategoria());
            return productoRepository.save(producto);
        });
    }

    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Producto> obtenerPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public boolean existePorNombre(String nombre) {
        Optional<Producto> productoExistente = productoRepository.findByNombre(nombre);
        return productoExistente.isPresent();
    }
    

}
