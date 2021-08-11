package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.Movimentacao;
import com.dio.santander.ponto.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(service.save(movimentacao));
    }

    @PutMapping
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(service.save(movimentacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
