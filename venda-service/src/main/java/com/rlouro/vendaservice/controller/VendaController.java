package com.rlouro.vendaservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.inject.Inject;
import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;
import com.rlouro.vendaservice.model.Venda;
import com.rlouro.vendaservice.service.IVendaService;

@RestController
@RequestMapping(path = "/venda")
public class VendaController {

    private final IVendaService vendaService;

    @Inject
    public VendaController(IVendaService vendaService) {
        this.vendaService = vendaService;
    }

    /**
     * Salva uma nova {@link Venda}.
     * @param dto
     * @return {@link VendaDTO} da {@link Venda} salva
     */
    @PostMapping
    public ResponseEntity<VendaDTO> save(@RequestBody VendaDTO dto) {
        return new ResponseEntity<>(vendaService.save(dto), HttpStatus.CREATED);
    }

    /**
     * Recupera uma {@link Venda} pelo id.
     * @param id
     * @return {@link VendaDTO} recuperada
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(vendaService.findById(id), HttpStatus.OK);
    }

    /**
     * Recupera uma lista de {@link Venda} pelo {@link VendaFilter}.
     * @param filter
     * @return page com as vendas
     */
    @GetMapping
    public ResponseEntity<Page<VendaBasicDTO>> findByFilter(@ModelAttribute("filter") VendaFilter filter) {
        return new ResponseEntity<>(vendaService.findByFilter(filter), HttpStatus.OK);
    }

}
