package com.littlebig.administracionlibros.utilidades;

import com.littlebig.administracionlibros.dto.AutorDto;
import com.littlebig.administracionlibros.dto.LibroDto;
import com.littlebig.administracionlibros.dto.ResponseAutor;
import com.littlebig.administracionlibros.dto.ResponseLibro;
import com.littlebig.administracionlibros.entidades.Autor;
import com.littlebig.administracionlibros.entidades.Libro;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UtilidadesEntidades {

    public static Libro requestToEntity(LibroDto libroDto) {
        Libro libro = new Libro();
        Autor autor = new Autor();
        libro.setIdLibro(libroDto.getIdLibro());
        libro.setTitulo(libroDto.getTitulo());
        libro.setEditorial(libroDto.getEditorial());
        libro.setCantidadPaginas(libroDto.getCantidadPaginas());
        libro.setPrecio(libroDto.getPrecio());
        libro.setFechaPublicacion(libroDto.getFechaPublicacion());

        autor.setIdAutor(libroDto.getIdAutor());
        libro.setAutor(autor);
        return libro;
    }

    public static List<AutorDto> convertToDtoList(List<Autor> autores) {
        return Optional.ofNullable(autores)
                .orElse(Collections.emptyList())
                .stream()
                .map(UtilidadesEntidades::responseToDto)
                .collect(Collectors.toList());
    }

    public static AutorDto responseToDto(Autor autor){
        AutorDto autorDto = new AutorDto();
        autorDto.setIdAutor(autor.getIdAutor());
        autorDto.setNombres(autor.getNombres());
        autorDto.setApellidos(autor.getApellidos());
        List<LibroDto> librosDto = Optional.ofNullable(autor.getLibros())
                .orElse(Collections.emptyList())
                .stream()
                .map(UtilidadesEntidades::responseToDto)
                .collect(Collectors.toList());
        autorDto.setLibros(librosDto);
        return autorDto;
    }


    public static List<LibroDto> convertToDtoListLibros(List<Libro> libros) {
        return Optional.ofNullable(libros)
                .orElse(Collections.emptyList())
                .stream()
                .map(UtilidadesEntidades::responseToDto)
                .collect(Collectors.toList());
    }

    public static LibroDto responseToDto(Libro libro){
        LibroDto libroDto = new LibroDto();
        libroDto.setIdLibro(libro.getIdLibro());
        libroDto.setPrecio(libro.getPrecio());
        libroDto.setEditorial(libro.getEditorial());
        libroDto.setTitulo(libro.getTitulo());
        libroDto.setCantidadPaginas(libro.getCantidadPaginas());
        libroDto.setFechaPublicacion(libro.getFechaPublicacion());
        Autor autor= libro.getAutor();
        libroDto.setIdAutor(autor!=null?autor.getIdAutor():null);
        libroDto.setAutor(autor!=null?autor.getNombres()+" "+autor.getApellidos():null);
        return libroDto;

    }

    public static Autor requestToEntity(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setIdAutor(autorDto.getIdAutor());
        autor.setNombres(autorDto.getNombres());
        autor.setApellidos(autorDto.getApellidos());
        return autor;
    }

    public static ResponseLibro inicializeResponseLibro(){
        ResponseLibro response = new ResponseLibro();
        response.setCodigo(HttpStatus.OK.value());
        response.setMensaje(HttpStatus.OK.name());
        return response;
    }

    public static ResponseAutor inicializeResponseAutor(){
        ResponseAutor response = new ResponseAutor();
        response.setCodigo(HttpStatus.OK.value());
        response.setMensaje(HttpStatus.OK.name());
        return response;
    }
}
