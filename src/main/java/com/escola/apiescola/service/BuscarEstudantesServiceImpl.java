package com.escola.apiescola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.apiescola.datasource.model.Estudante;
import com.escola.apiescola.repository.EstudanteRepository;

@Service
public class BuscarEstudantesServiceImpl {

	@Autowired
	private EstudanteRepository repository;

	public List<Estudante> buscarEstudantes() {
		List<Estudante> lst = repository.findAll();
		return lst;
	}
}
