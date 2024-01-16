package com.acl.crud.controllerui;

import com.acl.crud.model.Libro;
import com.acl.crud.service.LibroService;  // Asegúrate de importar LibroService

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final LibroService libroService;

    public HomeController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/")
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.findAll();
        
        model.addAttribute("libros", libros);

        return "listar-libro";
    }

    @GetMapping("/crear-libro")
    public String crearLibro() {
        return "crear-libro";
    }

    @PostMapping("/guardar-libro")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/"; 
    }

    @GetMapping("/editar-libro/{id}")
    public String editarLibro(@PathVariable String id, Model model) {
        Libro libro = libroService.findById(id);
        
        model.addAttribute("libro", libro);

        return "editar-libro";
    }

    @PostMapping("/guardar-edicion-libro")
    public String guardarEdicionLibro(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/"; 
    }
    
    @GetMapping("/eliminar-libro/{id}")
    public String eliminarLibro(@PathVariable String id) {
        libroService.deleteById(id);
        return "redirect:/"; 
    }
    
}
