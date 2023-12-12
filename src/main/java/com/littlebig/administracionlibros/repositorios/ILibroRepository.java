package com.littlebig.administracionlibros.repositorios;

import com.littlebig.administracionlibros.entidades.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILibroRepository extends CrudRepository<Libro,Integer> {
    public List<Libro> findByIdLibro(Integer idLibro);
    public List<Libro> findByTitulo(String titulo);
    public List<Libro> findByEditorial(String editorial);
}
