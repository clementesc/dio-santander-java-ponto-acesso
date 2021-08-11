package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.NivelAcesso;
import com.dio.santander.ponto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/nivel-acesso")
public class NivelAcessoController {

    @Autowired
    private NivelAcessoService service;

    @GetMapping
    public ResponseEntity<List<NivelAcesso>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NivelAcesso> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<NivelAcesso> createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(service.save(nivelAcesso));
    }

    @PutMapping
    public ResponseEntity<NivelAcesso> updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(service.save(nivelAcesso));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteNivelAcesso(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
