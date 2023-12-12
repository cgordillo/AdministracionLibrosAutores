package com.littlebig.administracionlibros.service;

import com.littlebig.administracionlibros.entidades.Libro;
import com.littlebig.administracionlibros.repositorios.ILibroRepository;
import com.littlebig.administracionlibros.service.interfaz.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService implements ILibroService {
    @Autowired
    private ILibroRepository iLibroRepository;

    @Override
    public List<Libro> findByIdLibro(Integer idLibro) {
        return iLibroRepository.findByIdLibro(idLibro);
    }

    @Override
    public List<Libro> findByTitulo(String titulo) {
        return iLibroRepository.findByTitulo(titulo);
    }

    @Override
    public List<Libro> findByEditorial(String editorial) {
        return iLibroRepository.findByEditorial(editorial);
    }

    @Override
    public List<Libro> findAll() {
        Iterable<Libro> librosIterable = iLibroRepository.findAll();
        List<Libro> librosList = new ArrayList<>();
        librosIterable.forEach(librosList::add);
        return librosList;
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return iLibroRepository.save(libro);
    }

    @Override
    public void deleteLibro(Integer idLibro) {
        iLibroRepository.deleteById(idLibro);
    }
}
