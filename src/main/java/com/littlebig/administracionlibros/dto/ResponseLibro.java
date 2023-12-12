package com.littlebig.administracionlibros.dto;

import com.littlebig.administracionlibros.entidades.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseLibro {
    private Integer codigo;
    private String mensaje;
    private List<LibroDto> libros;
}
