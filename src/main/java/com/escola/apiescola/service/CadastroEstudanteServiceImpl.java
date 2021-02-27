package com.escola.apiescola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.apiescola.datasource.model.Estudante;
import com.escola.apiescola.exception.EstudanteResourceException;
import com.escola.apiescola.repository.EstudanteRepository;
import com.escola.apiescola.resource.model.EstudanteResource;

@Service
public class CadastroEstudanteServiceImpl {

	@Autowired
	private EstudanteRepository repository;
	@Autowired
	private EstudanteConversor conv;

	public void cadastrar(EstudanteResource estudanteRes) throws EstudanteResourceException {
		try {
			Estudante estudante = conv.converter(estudanteRes);
			repository.saveAndFlush(estudante);
		} catch (EstudanteResourceException e) {
			e.printStackTrace();
		}
	}
}
