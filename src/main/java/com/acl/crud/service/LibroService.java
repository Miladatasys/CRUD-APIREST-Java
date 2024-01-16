package com.acl.crud.service;

import com.acl.crud.model.Libro;
import com.acl.crud.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(String id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteById(String id) {
        libroRepository.deleteById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return libroRepository.existsById(titulo);
    }
}
