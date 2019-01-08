package com.rlouro.vendaservice.service;

import java.util.List;

import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;

public interface IDiscoService {

	DiscoDTO save(DiscoDTO dto);

	DiscoDTO findById(Long id);

	List<DiscoBasicDTO> findByFilter(DiscoFilter filter);
}
