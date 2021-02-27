package com.escola.apiescola.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.apiescola.datasource.model.Estudante;
import com.escola.apiescola.exception.EstudanteNotFoundException;
import com.escola.apiescola.exception.EstudanteResourceException;
import com.escola.apiescola.repository.EstudanteRepository;
import com.escola.apiescola.resource.model.EstudanteResource;

@Service
public class BuscarEstudantePorIdServiceImpl {

	@Autowired
	private EstudanteRepository repository;
	@Autowired
	private EstudanteConversor conversor;

	private Optional<Estudante> getOptional(Long id) {
		Optional<Estudante> estudante = repository.findById(id);
		return estudante;
	}

	public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException {
		Optional<Estudante> optEstudante = getOptional(id);
		Estudante estudante = null;
		if (!optEstudante.isPresent()) {
			throw new EstudanteNotFoundException("Estudante com id: " + id + " não existe");
		} else {
			estudante = optEstudante.get();
		}
		return estudante;
	}

	public void deletarEstudantePorId(Long id) throws EstudanteNotFoundException {
		Optional<Estudante> optEstudante = getOptional(id);
		if (!optEstudante.isPresent()) {
			throw new EstudanteNotFoundException("Estudante com id: " + id + " não existe");
		} else {
			repository.deleteById(id);
		}
	}

	public void editarEstudantePorId(Long id, EstudanteResource estudanteRes)
			throws EstudanteNotFoundException, EstudanteResourceException {
		
		Optional<Estudante> optEstudante = getOptional(id);
		
		if (!optEstudante.isPresent()) {
			throw new EstudanteNotFoundException("Estudante com id: " + id + " não existe");
		} else {
			Estudante estudante = conversor.converter(estudanteRes);
			estudante.setId(optEstudante.get().getId());
			repository.saveAndFlush(estudante);
		}
	}

}
