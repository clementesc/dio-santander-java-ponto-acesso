package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.Ocorrencia;
import com.dio.santander.ponto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ocorrencia> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(service.save(ocorrencia));
    }

    @PutMapping
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(service.save(ocorrencia));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOcorrencia(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
