package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.TipoData;
import com.dio.santander.ponto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/tipo-data")
public class TipoDataController {

    @Autowired
    private TipoDataService service;

    @GetMapping
    public ResponseEntity<List<TipoData>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoData> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoData> createTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(service.save(tipoData));
    }

    @PutMapping
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(service.save(tipoData));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTipoData(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
