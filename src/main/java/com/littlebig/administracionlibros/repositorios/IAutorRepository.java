package com.littlebig.administracionlibros.repositorios;

import com.littlebig.administracionlibros.entidades.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAutorRepository extends CrudRepository<Autor,Integer> {
    public List<Autor> findByIdAutor(Integer idAutor);
}
