package org.example.gestorapi.controller;


import org.example.gestorapi.model.Profesor;
import org.example.gestorapi.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acex")
public class ProfesorController {
    @Autowired
    private ProfesorServiceImpl profesorService;


    @GetMapping("/profesores")
    public ResponseEntity<?> getProfesores() {
        List<Profesor> profesores = profesorService.findAll();
        if (profesores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(profesores);
        }
    }

    @GetMapping("/profesores/{correo}")
    public ResponseEntity<?> getProfesorById(@PathVariable String correo) {
        Profesor profesor = profesorService.findByEmail(correo);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(profesor);
        }
    }

    @PostMapping("/profesores")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        Profesor nuevo = profesorService.guardar(profesor);
        if (nuevo == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        }
    }

    @PutMapping("/profesores/{id}")
    public ResponseEntity<?> updateProfesor(@PathVariable String id, @RequestBody Profesor profesor) {
        Profesor actualizado = profesorService.findById(id);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(profesorService.actualizar(profesor,id));
        }
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Profesor> deleteProfesor(@PathVariable String id) {
        Profesor eliminado = profesorService.findById(id);
        if (eliminado == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(profesorService.eliminar(id));
        }
    }

    @GetMapping("/profesores/inicio")
    public ResponseEntity<?> inicioSesion(@RequestParam String correo, @RequestParam String password) {
        Profesor profesor = profesorService.inicioSesion(correo, password);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(profesor);
        }
    }
}
