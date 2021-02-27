package com.escola.apiescola.datasource.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Estudante implements Serializable {

	private static final long serialVersionUID = -1301312353875668818L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50, min = 3, message = "Max: 60 e Min: 3 para o [nome]")
	@NotBlank(message = "[nome] e obrigatorio")
	private String nome;

	@NotNull(message = "[idade] e obrigatorio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate idade;

	@NotNull(message = "[matricula] e obrigatorio")
	@Max(value = 9999)
	private Long matricula;

	@NotNull(message = "[idProfessor] e obrigatorio")
	@DecimalMax(value = "99", message = "Valor Maximo:99 para o [idProfessor] ")
	private Long idProfessor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getIdade() {
		return idade;
	}

	public void setIdade(LocalDate idade) {
		this.idade = idade;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", idade=" + idade + ", matricula=" + matricula
				+ ", idProfessor=" + idProfessor + "]";
	}

}
