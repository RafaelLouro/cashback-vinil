package com.rlouro.vendaservice.service;

import java.util.List;

import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;

public interface IVendaService {

	VendaDTO save(VendaDTO dto);

	VendaDTO findById(Long id);

	List<VendaBasicDTO> findByFilter(VendaFilter filter);

}
