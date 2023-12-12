package com.littlebig.administracionlibros.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseAutor {
    private Integer codigo;
    private String mensaje;
    private List<AutorDto> autores;
}
