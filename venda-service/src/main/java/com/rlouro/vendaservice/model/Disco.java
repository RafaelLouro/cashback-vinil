package com.rlouro.vendaservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DISCO")
public class Disco implements Serializable {

	private static final long serialVersionUID = 307857694331505019L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DI_ID")
	private Long id;

	@Size(max = 50)
	@Column(name = "DI_DS_NOME", nullable = false)
	private String nome;

	@Column(name = "DI_VL_PRECO", nullable = false)
	private Double preco;

	@JoinColumn(name = "GE_ID", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Genero genero;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Disco() {
	}

	public Disco(Long id, @Size(max = 50) String nome, Double preco, Genero genero) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.genero = genero;
	}
}
