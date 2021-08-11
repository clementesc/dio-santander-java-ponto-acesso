package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.NivelAcesso;
import com.dio.santander.ponto.repository.NivelAcessoRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAcessoService {

    @Autowired
    private NivelAcessoRepository repository;

    public List<NivelAcesso> findAll() {
        return repository.findAll();
    }

    public NivelAcesso findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public NivelAcesso save(NivelAcesso nivelAcesso){
        return repository.save(nivelAcesso);
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
