package com.littlebig.administracionlibros.controller.rest;

import com.littlebig.administracionlibros.dto.AutorDto;
import com.littlebig.administracionlibros.dto.ResponseAutor;
import com.littlebig.administracionlibros.entidades.Autor;
import com.littlebig.administracionlibros.service.AutorService;
import com.littlebig.administracionlibros.utilidades.UtilidadesEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/AdministracionAutores/V1.0",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministracionAutoresController {
    @Autowired
    public AutorService autorService;

    private ResponseAutor response;
    private Autor autor;

    @PostMapping("/crearAutor")
    public ResponseEntity<?> crearAutor(@RequestBody AutorDto autorDto){
        try{
            return getResponseEntity(autorDto);
        }
        catch(Exception e){
            response.setCodigo(HttpStatus.EXPECTATION_FAILED.value());
            response.setMensaje(HttpStatus.EXPECTATION_FAILED.name()+" -->"+e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);

        }
    }

    @GetMapping("/consultarAutor")
    public ResponseEntity<?> consultarAutor(@RequestParam(required = false)  Integer idAutor)
    {
        response = UtilidadesEntidades.inicializeResponseAutor();
        if(idAutor != null){
            List<Autor> autores= autorService.findByIdAutor(idAutor);
            response.setAutores(UtilidadesEntidades.convertToDtoList(autores));
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else{
            List<Autor> autores= autorService.findAll();
            response.setAutores(UtilidadesEntidades.convertToDtoList(autores));
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

    @PutMapping("/actualizarAutor")
    public ResponseEntity<?> actualizarAutor(@RequestBody AutorDto autorDto){
        return getResponseEntity(autorDto);
    }

    @DeleteMapping("/eliminarAutor")
    public ResponseEntity<?> eliminarAutor(@RequestParam Integer idAutor){
        try{
            response = UtilidadesEntidades.inicializeResponseAutor();
            autorService.deleteAutor(idAutor);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch(Exception e){
            response.setCodigo(HttpStatus.EXPECTATION_FAILED.value());
            response.setMensaje(HttpStatus.EXPECTATION_FAILED.name()+" -->"+e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }

    private ResponseEntity<?> getResponseEntity(AutorDto autorDto) {
        autor = UtilidadesEntidades.requestToEntity(autorDto);
        response = UtilidadesEntidades.inicializeResponseAutor();
        List<Autor> autores = new ArrayList<>();
        autores.add(autorService.saveAutor(autor));
        response.setAutores(UtilidadesEntidades.convertToDtoList(autores));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
