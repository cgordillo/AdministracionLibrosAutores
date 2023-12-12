package com.littlebig.administracionlibros.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "AUTOR")
public class Autor {
    @Id
    @Column(name = "ID_AUTOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    @Column(name = "NOMBRES",nullable = false)
    private String nombres;
    @Column(name = "APELLIDOS",nullable = false)
    private String apellidos;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;
}
