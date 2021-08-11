package com.dio.santander.ponto.controller;

import com.dio.santander.ponto.model.BancoHoras;
import com.dio.santander.ponto.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/banco-horas")
public class BancoHorasController {

    @Autowired
    private BancoHorasService bancoHorasService;

    @GetMapping
    public ResponseEntity<List<BancoHoras>> findAll(){
        return ResponseEntity.ok(bancoHorasService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BancoHoras> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(bancoHorasService.findById(id).orElseThrow(()-> new NoSuchElementException("Not found")));
    }

    @PostMapping
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @PutMapping
    public ResponseEntity<BancoHoras> updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBancoHoras(@PathVariable("id") Integer id){
        bancoHorasService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
