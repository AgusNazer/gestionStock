package com.gestionstock.demo.service;

import com.gestionstock.demo.DTO.CategoriaDTO;
import com.gestionstock.demo.mapper.CategoriaMapper;
import com.gestionstock.demo.model.Categoria;
import com.gestionstock.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    
    

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorías ( la entidad, no el DTO)
    // public List<Categoria> obtenerTodas() {
    //     return categoriaRepository.findAll();
    // }

    // convertir categoria a categoriaDTO
 // Convertir Categoria a CategoriaDTO
//     private CategoriaDTO convertirACategoriaDTO(Categoria categoria) {
//     return new CategoriaDTO(
//         categoria.getNombre()
//     );
// }

// Obtener todas las categorías y devolver solo los datos necesarios
public List<CategoriaDTO> obtenerTodas() {
    List<Categoria> categorias = categoriaRepository.findAll();
    return CategoriaMapper.toDTOList(categorias);
}


    // Obtener una categoría por ID
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }
        // Obtener una categoría por nombre
        public Optional<Categoria> obtenerPorNombre(String nombre) {
            return categoriaRepository.findByNombre(nombre);
        }
            // Guardar una nueva categoría solo si no existe
    public Categoria guardarCategoria(Categoria categoria) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findByNombre(categoria.getNombre());
        return categoriaExistente.orElseGet(() -> categoriaRepository.save(categoria));
    }

    // Actualizar una categoría
    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria) {
        return categoriaRepository.findById(id).map(existingCategoria -> {
            existingCategoria.setNombre(categoria.getNombre());
            return categoriaRepository.save(existingCategoria);
        });
    }

    // Eliminar una categoría
    public boolean eliminarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


// AGREGAR DTOs a categorias