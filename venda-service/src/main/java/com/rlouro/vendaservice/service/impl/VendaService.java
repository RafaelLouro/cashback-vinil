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
import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;
import com.rlouro.vendaservice.model.ItemVenda;
import com.rlouro.vendaservice.model.Venda;
import com.rlouro.vendaservice.repository.VendaRepository;
import com.rlouro.vendaservice.service.IVendaService;

@Service
public class VendaService extends BaseService implements IVendaService {

	private final VendaRepository vendaRepository;

	@Inject
	public VendaService(VendaRepository vendaRepository) {
		super(new ModelMapper());
		this.vendaRepository = vendaRepository;
	}

	@Override
	public VendaDTO save(VendaDTO dto) {
		Venda entity = modelMapper.map(dto, Venda.class);
		entity = vendaRepository.save(entity);

		dto = modelMapper.map(entity, VendaDTO.class);

		for (ItemVenda item : entity.getItemList()) {
			dto.getDiscos().add(modelMapper.map(item.getDisco(), DiscoBasicDTO.class));
		}

		return dto;
	}

	@Override
	public VendaDTO findById(Long id) {
		Validate.notNull(id, GET_ID_NAO_INFORMADO_MESSAGE);

		Optional<Venda> opEntity = vendaRepository.findById(id);

		if (opEntity.isPresent()) {
			return modelMapper.map(opEntity.get(), VendaDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public List<VendaBasicDTO> findByFilter(VendaFilter filter) {
		Type targetListType = new TypeToken<List<VendaBasicDTO>>() {
		}.getType();

		return modelMapper.map(vendaRepository.findAll(), targetListType);
	}

}
