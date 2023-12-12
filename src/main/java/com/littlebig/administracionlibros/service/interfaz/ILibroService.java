package com.littlebig.administracionlibros.service.interfaz;

import com.littlebig.administracionlibros.entidades.Libro;
import com.littlebig.administracionlibros.repositorios.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILibroService {
    public List<Libro> findByIdLibro(Integer idLibro);
    public List<Libro> findByTitulo(String titulo);
    public List<Libro> findByEditorial(String editorial);
    public List<Libro> findAll();

    public Libro saveLibro(Libro libro);
    public void deleteLibro(Integer idLibro);
}
