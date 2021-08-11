package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.Localidade;
import com.dio.santander.ponto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @GetMapping
    public ResponseEntity<List<Localidade>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Localidade> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(service.save(localidade));
    }

    @PutMapping
    public ResponseEntity<Localidade> updateLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(service.save(localidade));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLocalidade(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
