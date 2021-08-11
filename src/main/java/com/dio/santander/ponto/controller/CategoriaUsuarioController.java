package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.CategoriaUsuario;
import com.dio.santander.ponto.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/categoria-usuario")
public class CategoriaUsuarioController {

    @Autowired
    private CategoriaUsuarioService service;

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaUsuario> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaUsuario> createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.ok(service.save(categoriaUsuario));
    }

    @PutMapping
    public ResponseEntity<CategoriaUsuario> updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.ok(service.save(categoriaUsuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoriaUsuario(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
