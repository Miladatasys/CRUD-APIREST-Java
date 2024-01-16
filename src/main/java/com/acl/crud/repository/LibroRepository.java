package com.acl.crud.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.acl.crud.model.Libro;

public interface LibroRepository extends MongoRepository<Libro, String> {
    
}