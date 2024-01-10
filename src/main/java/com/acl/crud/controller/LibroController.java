package com.acl.crud.controller;
import org.springframework.ui.Model;
import com.acl.crud.model.Libro;
import com.acl.crud.service.LibroService;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/libros", "/libros"})
public class LibroController {
    
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public String getAllLibros(Model model) {
        List<Libro> libros = libroService.findAll();
        model.addAttribute("libros", libros);
        return "libros";
    }

    @GetMapping("/libros")
    public String showLibros(Model model) {
    List<Libro> libros = libroService.findAll();
    model.addAttribute("libros", libros);
        return "libros";
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
    public Libro updateLibro(@PathVariable String id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.save(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable String id) {
        libroService.deleteById(id);
    }


}
