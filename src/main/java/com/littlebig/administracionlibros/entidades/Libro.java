package com.littlebig.administracionlibros.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "LIBRO")
public class Libro {
    @Id
    @Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;

    @Column(name = "TITULO",nullable = false)
    private String titulo;
    @Column(name = "EDITORIAL",nullable = false)
    private String editorial;
    @Column(name = "CANTIDAD_PAGINAS",nullable = false)
    private Integer cantidadPaginas;
    @Column(name = "PRECIO",nullable = false)
    private Double precio;
    @Column(name = "FECHA_PUBLICACION",nullable = false)
    private LocalDate fechaPublicacion;
}
