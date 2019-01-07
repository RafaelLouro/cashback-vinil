package com.rlouro.vendaservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GENERO")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GE_ID")
	private Long id;

	@Size(max = 50)
	@Column(name = "GE_DS_NOME", nullable = false)
	private String nome;
}
