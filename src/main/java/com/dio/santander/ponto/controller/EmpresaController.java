package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.Empresa;
import com.dio.santander.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(service.save(empresa));
    }

    @PutMapping
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(service.save(empresa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
