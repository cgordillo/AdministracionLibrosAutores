package com.littlebig.administracionlibros.service.interfaz;

import com.littlebig.administracionlibros.entidades.Autor;

import java.util.List;

public interface IAutorService {
    public List<Autor> findByIdAutor(Integer idAutor);
    public List<Autor> findAll();

    public Autor saveAutor(Autor autor);
    public void deleteAutor(Integer idAutor);
}
