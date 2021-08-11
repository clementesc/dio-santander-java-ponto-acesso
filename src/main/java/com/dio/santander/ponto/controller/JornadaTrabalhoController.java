package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.JornadaTrabalho;
import com.dio.santander.ponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaService service;

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalho> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(service.save(jornadaTrabalho));
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(service.save(jornadaTrabalho));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteJornada(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
