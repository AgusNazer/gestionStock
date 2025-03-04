package com.gestionstock.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.model.Producto;
import com.gestionstock.demo.service.CategoriaService;
import com.gestionstock.demo.service.ProductoService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
public void run(String... args) throws Exception {
    // Verificar si ya existen categorías antes de crearlas
    if (categoriaService.obtenerPorNombre("Laptops").isEmpty()) {
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Laptops");
        categoriaService.guardarCategoria(categoria1);
    }

    if (categoriaService.obtenerPorNombre("Perifericos").isEmpty()) {
        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Perifericos");
        categoriaService.guardarCategoria(categoria2);
    }
    if (categoriaService.obtenerPorNombre("Sillas").isEmpty()) {
        Categoria categoria3 = new Categoria();
        categoria3.setNombre("Sillas");
        categoriaService.guardarCategoria(categoria3);
    }

    // Obtener categorías para asignarlas a productos
    Categoria categoriaLaptops = categoriaService.obtenerPorNombre("Laptops").orElseThrow();
    Categoria categoriaPerifericos = categoriaService.obtenerPorNombre("Perifericos").orElseThrow();
    Categoria categoriaSillas = categoriaService.obtenerPorNombre("Sillas").orElseThrow();

    // Verificar si los productos ya existen antes de crearlos
    if (!productoService.existePorNombre("Laptop ")) {
        Producto producto1 = new Producto();
        producto1.setNombre("Laptop");
        producto1.setDescripcion("Laptop Gamer");
        producto1.setPrecio(1500.0);
        producto1.setStock(10);
        producto1.setCategoria(categoriaLaptops);
        productoService.guardarProducto(producto1);
    }
    if (!productoService.existePorNombre("MacBook Pro")) {
        Producto producto2 = new Producto();
        producto2.setNombre("MacBook Pro");
        producto2.setDescripcion("MacBook Pro M2");
        producto2.setPrecio(2200.0);
        producto2.setStock(5);
        producto2.setCategoria(categoriaLaptops);
        productoService.guardarProducto(producto2);
    }

    if (!productoService.existePorNombre("Teclado Keychron pro")) {
        Producto producto2 = new Producto();
        producto2.setNombre("Teclado Keychron pro");
        producto2.setDescripcion("Teclado mecanico keychron k8 pro");
        producto2.setPrecio(200.0);
        producto2.setStock(20);
        producto2.setCategoria(categoriaPerifericos);
        productoService.guardarProducto(producto2);
    }
    if (!productoService.existePorNombre("Mouse Logitech G Pro")) {
        Producto producto5 = new Producto();
        producto5.setNombre("Mouse Logitech G Pro");
        producto5.setDescripcion("Mouse gaming inalámbrico");
        producto5.setPrecio(120.0);
        producto5.setStock(15);
        producto5.setCategoria(categoriaPerifericos);
        productoService.guardarProducto(producto5);
    }
    if (!productoService.existePorNombre("Monitor LG 4K")) {
        Producto producto6 = new Producto();
        producto6.setNombre("Monitor LG 4K");
        producto6.setDescripcion("Monitor Ultra HD 27 pulgadas");
        producto6.setPrecio(350.0);
        producto6.setStock(10);
        producto6.setCategoria(categoriaPerifericos);
        productoService.guardarProducto(producto6);
    }
    if (!productoService.existePorNombre("Silla de Oficina")) {
        Producto producto7 = new Producto();
        producto7.setNombre("Silla de Oficina");
        producto7.setDescripcion("Silla ergonómica con soporte lumbar");
        producto7.setPrecio(180.0);
        producto7.setStock(12);
        producto7.setCategoria(categoriaSillas);
        productoService.guardarProducto(producto7);
    }
    if (!productoService.existePorNombre("Silla Gamer RGB")) {
        Producto producto8 = new Producto();
        producto8.setNombre("Silla Gamer RGB");
        producto8.setDescripcion("Silla gamer con iluminación LED");
        producto8.setPrecio(250.0);
        producto8.setStock(8);
        producto8.setCategoria(categoriaSillas);
        productoService.guardarProducto(producto8);
    }

    System.out.println("Datos inicializados correctamente.");
}

}
