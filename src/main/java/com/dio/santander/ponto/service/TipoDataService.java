package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.TipoData;
import com.dio.santander.ponto.repository.TipoDataRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDataService {

    @Autowired
    private TipoDataRepository repository;

    public List<TipoData> findAll() {
        return repository.findAll();
    }

    public TipoData findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public TipoData save(TipoData tipoData){
        return repository.save(tipoData);
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
