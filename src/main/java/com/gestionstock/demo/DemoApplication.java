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
    if (categoriaService.obtenerPorNombre("Electrónica").isEmpty()) {
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Electrónica");
        categoriaService.guardarCategoria(categoria1);
    }

    if (categoriaService.obtenerPorNombre("Hogar").isEmpty()) {
        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hogar");
        categoriaService.guardarCategoria(categoria2);
    }

    // Obtener categorías para asignarlas a productos
    Categoria categoriaElectronica = categoriaService.obtenerPorNombre("Electrónica").orElseThrow();
    Categoria categoriaHogar = categoriaService.obtenerPorNombre("Hogar").orElseThrow();

    // Verificar si los productos ya existen antes de crearlos
    if (!productoService.existePorNombre("Laptop")) {
        Producto producto1 = new Producto();
        producto1.setNombre("Laptop");
        producto1.setDescripcion("Laptop Gamer");
        producto1.setPrecio(1500.0);
        producto1.setStock(10);
        producto1.setCategoria(categoriaElectronica);
        productoService.guardarProducto(producto1);
    }

    if (!productoService.existePorNombre("Silla de Oficina")) {
        Producto producto2 = new Producto();
        producto2.setNombre("Silla de Oficina");
        producto2.setDescripcion("Silla ergonómica");
        producto2.setPrecio(200.0);
        producto2.setStock(20);
        producto2.setCategoria(categoriaHogar);
        productoService.guardarProducto(producto2);
    }

    System.out.println("Datos inicializados correctamente.");
}

}
