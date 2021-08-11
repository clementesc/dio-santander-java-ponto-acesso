package com.dio.santander.ponto.service;

import com.dio.santander.ponto.model.CategoriaUsuario;
import com.dio.santander.ponto.repository.CategoriaUsuarioRepository;
import com.dio.santander.ponto.service.exceptions.DatabaseException;
import com.dio.santander.ponto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUsuarioService {

    @Autowired
    private CategoriaUsuarioRepository repository;

    public List<CategoriaUsuario> findAll() {
        return repository.findAll();
    }

    public CategoriaUsuario findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario){
        return repository.save(categoriaUsuario);
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
