package com.rlouro.vendaservice.service;

import org.springframework.data.domain.Page;
import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.model.Disco;

public interface IDiscoService {

    DiscoDTO save(DiscoDTO dto);

    DiscoDTO findById(Long id);

    Disco findEntityById(Long id);

    Page<DiscoBasicDTO> findByFilter(DiscoFilter filter);
}
