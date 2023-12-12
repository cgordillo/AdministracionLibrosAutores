package com.littlebig.administracionlibros.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LibroDto {
    private Integer idLibro;
    private Integer idAutor;
    private String autor;
    private String titulo;
    private String editorial;
    private Integer cantidadPaginas;
    private Double precio;
    private LocalDate fechaPublicacion;
}
