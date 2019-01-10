package com.rlouro.vendaservice.service;

import org.springframework.data.domain.Page;
import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;

public interface IDiscoService {

    DiscoDTO save(DiscoDTO dto);

    DiscoDTO findById(Long id);

    Page<DiscoBasicDTO> findByFilter(DiscoFilter filter);
}
