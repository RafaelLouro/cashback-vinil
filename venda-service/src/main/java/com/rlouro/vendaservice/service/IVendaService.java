package com.rlouro.vendaservice.service;

import org.springframework.data.domain.Page;
import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;

public interface IVendaService {

    VendaDTO save(VendaDTO dto);

    VendaDTO findById(Long id);

    Page<VendaBasicDTO> findByFilter(VendaFilter filter);

}
