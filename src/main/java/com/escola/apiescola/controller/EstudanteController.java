package com.escola.apiescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.apiescola.datasource.model.Estudante;
import com.escola.apiescola.exception.EstudanteNotFoundException;
import com.escola.apiescola.exception.EstudanteResourceException;
import com.escola.apiescola.resource.model.EstudanteResource;
import com.escola.apiescola.service.BuscarEstudantePorIdServiceImpl;
import com.escola.apiescola.service.BuscarEstudantesServiceImpl;
import com.escola.apiescola.service.CadastroEstudanteServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class EstudanteController {

	@Autowired
	private BuscarEstudantesServiceImpl buscaTodos;
	@Autowired
	private BuscarEstudantePorIdServiceImpl buscaId;
	@Autowired
	private CadastroEstudanteServiceImpl cad;

	@GetMapping(path = "/estudantes")
	public List<Estudante> buscarTodos() {
		return buscaTodos.buscarEstudantes();
	}

	@GetMapping(path = "/estudante-id/{id}")
	public Estudante buscarPorId(@PathVariable(value = "id", required = true) Long id)
			throws EstudanteNotFoundException {
		return buscaId.buscarEstudantePorId(id);
	}

	@DeleteMapping(path = "/delete/estudante/{id}")
	public void deletar(@PathVariable(name = "id", required = true) Long id) throws EstudanteNotFoundException {
		buscaId.deletarEstudantePorId(id);
	}

	@PostMapping(path = "/estudante/save")
	public void salvar(@RequestBody EstudanteResource estudanteRes) throws EstudanteResourceException {
		cad.cadastrar(estudanteRes);
	}

	@PutMapping(path = "/edit/estudante/{id}")
	public void editar(@PathVariable(name = "id", required = true) Long id,
			@RequestBody EstudanteResource estudanteResource)
			throws EstudanteNotFoundException, EstudanteResourceException {
		buscaId.editarEstudantePorId(id, estudanteResource);
	}
}
