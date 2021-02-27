package com.escola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.apiescola.datasource.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
	
}
