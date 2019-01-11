package com.rlouro.vendaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.service.IDiscoService;

@RestController
@RequestMapping(path = "/disco")
public class DiscoController {

	private final IDiscoService discoService;

	@Autowired
	public DiscoController(IDiscoService discoService) {
		this.discoService = discoService;
	}

	/**
	 * Recupera um {@link Disco} pelo id.
	 * 
	 * @param id
	 * @return {@link DiscoDTO} recuperado
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<DiscoDTO> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(discoService.findById(id), HttpStatus.OK);
	}

	/**
	 * Recupera uma lista de {@link Disco} pelo {@link DiscoFilter}.
	 * 
	 * @param filter
	 * @return page com os discos
	 */
	@GetMapping
	public ResponseEntity<Page<DiscoBasicDTO>> findByFilter(@ModelAttribute("filter") DiscoFilter filter) {
		return new ResponseEntity<>(discoService.findByFilter(filter), HttpStatus.OK);
	}

}
