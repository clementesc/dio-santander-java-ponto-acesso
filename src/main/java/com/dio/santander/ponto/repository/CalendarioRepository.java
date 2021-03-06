package com.dio.santander.ponto.repository;

import com.dio.santander.ponto.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {

}
