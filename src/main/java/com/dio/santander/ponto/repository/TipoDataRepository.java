package com.dio.santander.ponto.repository;

import com.dio.santander.ponto.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Integer> {

}
