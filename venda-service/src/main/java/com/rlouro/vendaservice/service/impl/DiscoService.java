package com.rlouro.vendaservice.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.commons.lang.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.repository.DiscoRepository;
import com.rlouro.vendaservice.service.IDiscoService;

@Service
public class DiscoService extends BaseService implements IDiscoService {

	private final DiscoRepository discoRepository;

	@Inject
	public DiscoService(DiscoRepository discoRepository) {
		super(new ModelMapper());
		this.discoRepository = discoRepository;
	}

	@Override
	public DiscoDTO save(DiscoDTO dto) {
		Disco entity = modelMapper.map(dto, Disco.class);
		entity = discoRepository.save(entity);

		return modelMapper.map(entity, DiscoDTO.class);
	}

	@Override
	public DiscoDTO findById(Long id) {
		Validate.notNull(id, GET_ID_NAO_INFORMADO_MESSAGE);

		Optional<Disco> opEntity = discoRepository.findById(id);

		if (opEntity.isPresent()) {
			return modelMapper.map(opEntity.get(), DiscoDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public List<DiscoBasicDTO> findByFilter(DiscoFilter filter) {
		Type targetListType = new TypeToken<List<DiscoBasicDTO>>() {
		}.getType();

		return modelMapper.map(discoRepository.findAll(), targetListType);
	}

}
