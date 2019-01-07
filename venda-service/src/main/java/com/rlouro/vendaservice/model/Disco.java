package com.rlouro.vendaservice.model;

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
public class Disco {

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
}
