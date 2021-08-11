package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.Calendario;
import com.dio.santander.ponto.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/calendario")
public class CalendarioController {

    @Autowired
    private CalendarioService service;

    @GetMapping
    public ResponseEntity<List<Calendario>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Calendario> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(service.save(calendario));
    }

    @PutMapping
    public ResponseEntity<Calendario> updateCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(service.save(calendario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCalendario(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
