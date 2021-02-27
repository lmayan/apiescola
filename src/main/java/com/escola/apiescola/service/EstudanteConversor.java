package com.escola.apiescola.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.escola.apiescola.datasource.model.Estudante;
import com.escola.apiescola.exception.EstudanteResourceException;
import com.escola.apiescola.resource.model.EstudanteResource;

@Component
public class EstudanteConversor {

	public Estudante converter(EstudanteResource estudanteResource) throws EstudanteResourceException {

		try {
			Estudante estudante = new Estudante();

			LocalDate idade = checkIdade(estudanteResource.getIdade());
			Long matricula = checkMatricula(estudanteResource.getMatricula());
			Long idProfessor = checkIdProfessor(estudanteResource.getIdProfessor());

			estudante.setIdade(idade);
			estudante.setMatricula(matricula);
			estudante.setIdProfessor(idProfessor);
			estudante.setNome(estudanteResource.getNome());

			return estudante;

		} catch (Exception e) {
			throw new EstudanteResourceException(
					"Falha ao converter EstudanteResource: " + estudanteResource.toString());
		}
	}

	// Metodos Conversores
	public LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}

	public Long checkMatricula(String matricula) {
		return Long.parseLong(matricula);
	}

	public Long checkIdProfessor(String idProfessor) {
		return Long.parseLong(idProfessor);
	}

}
