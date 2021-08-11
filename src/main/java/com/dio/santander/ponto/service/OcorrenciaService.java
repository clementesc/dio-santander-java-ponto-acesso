package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.Ocorrencia;
import com.dio.santander.ponto.repository.OcorrenciaRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public List<Ocorrencia> findAll() {
        return repository.findAll();
    }

    public Ocorrencia findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Ocorrencia save(Ocorrencia ocorrencia){
        return repository.save(ocorrencia);
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
