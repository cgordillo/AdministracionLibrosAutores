package com.littlebig.administracionlibros.service;

import com.littlebig.administracionlibros.entidades.Autor;
import com.littlebig.administracionlibros.repositorios.IAutorRepository;
import com.littlebig.administracionlibros.service.interfaz.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private IAutorRepository iAutorRepository;

    @Override
    public List<Autor> findByIdAutor(Integer idAutor) {
        return iAutorRepository.findByIdAutor(idAutor);
    }

    @Override
    public List<Autor> findAll() {
        Iterable<Autor> autoresIterable = iAutorRepository.findAll();
        List<Autor> autoresList = new ArrayList<>();
        autoresIterable.forEach(autoresList::add);
        return autoresList;
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return iAutorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Integer idAutor) {
        iAutorRepository.deleteById(idAutor);
    }
}
