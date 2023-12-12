package com.littlebig.administracionlibros.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutorDto {
    private Integer idAutor;
    private String nombres;
    private String apellidos;
    private List<LibroDto> libros;
}
