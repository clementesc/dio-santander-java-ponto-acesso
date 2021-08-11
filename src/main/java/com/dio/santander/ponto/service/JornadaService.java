package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.JornadaTrabalho;
import com.dio.santander.ponto.repository.JornadaRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository repository;

    public List<JornadaTrabalho> findAll() {
        return repository.findAll();
    }

    public JornadaTrabalho findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return repository.save(jornadaTrabalho);
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
