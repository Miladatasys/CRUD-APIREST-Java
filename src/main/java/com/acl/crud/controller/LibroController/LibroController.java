package com.acl.crud.controller.LibroController;
import com.acl.crud.model.Libro;
import com.acl.crud.service.LibroService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable String id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable String id, @RequestBody Libro libro) {
        Libro existingLibro = libroService.findById(id);
        if (existingLibro == null) {
            return ResponseEntity.notFound().build();
        }

        existingLibro.setTitulo(libro.getTitulo());
        existingLibro.setAutor(libro.getAutor());
        existingLibro.setEditorial(libro.getEditorial());
        existingLibro.setAñoPublicacion(libro.getAñoPublicacion());

        Libro updatedLibro = libroService.save(existingLibro);

        return ResponseEntity.ok(updatedLibro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable String id) {
        libroService.deleteById(id);
    }


}
