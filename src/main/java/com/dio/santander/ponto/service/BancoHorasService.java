package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.BancoHoras;
import com.dio.santander.ponto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository repository;

    public List<BancoHoras> findAll() {
        return repository.findAll();
    }

    public Optional<BancoHoras> findById(Integer id) {
        return repository.findById(id);
    }

    public BancoHoras save(BancoHoras bancoHoras){
        return repository.save(bancoHoras);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
