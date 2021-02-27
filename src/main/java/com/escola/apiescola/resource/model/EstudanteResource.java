package com.escola.apiescola.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstudanteResource {

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "idade")
	private String idade;

	@JsonProperty(value = "matricula")
	private String matricula;

	@JsonProperty(value = "id_professor")
	private String idProfessor;

	public EstudanteResource(String nome, String idade, String matricula, String idProfessor) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(String idProfesor) {
		this.idProfessor = idProfesor;
	}

	@Override
	public String toString() {
		return "EstudanteResource [nome=" + nome + ", idade=" + idade + ", matricula=" + matricula + ", idProfesor="
				+ idProfessor + "]";
	}

}
