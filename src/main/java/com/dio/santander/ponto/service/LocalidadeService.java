package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.Localidade;
import com.dio.santander.ponto.repository.LocalidadeRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;

    public List<Localidade> findAll() {
        return repository.findAll();
    }

    public Localidade findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Localidade save(Localidade localidade){
        return repository.save(localidade);
    }

    public void delete(Integer id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
