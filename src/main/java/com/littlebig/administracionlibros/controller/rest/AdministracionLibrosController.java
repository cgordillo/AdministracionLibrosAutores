package com.littlebig.administracionlibros.controller.rest;

import com.littlebig.administracionlibros.dto.LibroDto;
import com.littlebig.administracionlibros.dto.ResponseLibro;
import com.littlebig.administracionlibros.entidades.Libro;
import com.littlebig.administracionlibros.service.LibroService;
import com.littlebig.administracionlibros.utilidades.Utilidades;
import com.littlebig.administracionlibros.utilidades.UtilidadesEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/AdministracionLibros/V1.0",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministracionLibrosController {
    @Autowired
    public LibroService libroService;

    private ResponseLibro response;
    private Libro libro;

    @PostMapping("/crearLibro")
    public ResponseEntity<?> crearLibro(@RequestBody LibroDto libroDto){
        return getResponseEntity(libroDto);
    }

    @GetMapping("/consultarLibro")
    public ResponseEntity<?> consultarLibro(@RequestParam(required = false)  Integer idLibro,
                                 @RequestParam(required = false) String titulo,
                                 @RequestParam(required = false)  String editorial)
    {
        response = UtilidadesEntidades.inicializeResponseLibro();
        List<Libro> libros;
        if(idLibro != null){
            libros= libroService.findByIdLibro(idLibro);
        }
        else if(!Utilidades.esCampoNuloVacio(titulo)){
            libros= libroService.findByTitulo(titulo);
        }
        else if(!Utilidades.esCampoNuloVacio(editorial)){
            libros= libroService.findByEditorial(editorial);
        }
        else{
            libros= libroService.findAll();
        }
        response.setLibros(UtilidadesEntidades.convertToDtoListLibros(libros));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/actualizarLibro")
    public ResponseEntity<?> actualizarLibro(@RequestBody LibroDto libroDto){
        return getResponseEntity(libroDto);
    }

    @DeleteMapping("/eliminarLibro")
    public ResponseEntity<?> eliminarLibro(@RequestParam Integer idLibro){
        try{
            response = UtilidadesEntidades.inicializeResponseLibro();
            libroService.deleteLibro(idLibro);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch(Exception e){
            response.setCodigo(HttpStatus.EXPECTATION_FAILED.value());
            response.setMensaje(HttpStatus.EXPECTATION_FAILED.name()+" -->"+e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }

    private ResponseEntity<?> getResponseEntity(LibroDto libroDto) {
        try{
            libro = UtilidadesEntidades.requestToEntity(libroDto);
            response = UtilidadesEntidades.inicializeResponseLibro();
            libro = libroService.saveLibro(libro);

            List<LibroDto> librosDto = new ArrayList<>();            ;
            librosDto.add(UtilidadesEntidades.responseToDto(libro));

            response.setLibros(librosDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            response.setCodigo(HttpStatus.EXPECTATION_FAILED.value());
            response.setMensaje(HttpStatus.EXPECTATION_FAILED.name()+" -->"+e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);

        }
    }
}
