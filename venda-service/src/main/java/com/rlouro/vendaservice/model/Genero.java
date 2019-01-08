package com.rlouro.vendaservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GENERO")
public class Genero implements Serializable {

	private static final long serialVersionUID = -2716486927800494337L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GE_ID")
	private Long id;

	@Size(max = 50)
	@Column(name = "GE_DS_NOME", nullable = false)
	private String nome;

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

	public Genero() {
	}

	public Genero(Long id, @Size(max = 50) String nome) {
		this.id = id;
		this.nome = nome;
	}
}
