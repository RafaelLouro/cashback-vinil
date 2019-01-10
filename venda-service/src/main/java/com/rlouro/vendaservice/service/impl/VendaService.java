package com.rlouro.vendaservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.commons.lang.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;
import com.rlouro.vendaservice.model.ItemVenda;
import com.rlouro.vendaservice.model.Venda;
import com.rlouro.vendaservice.repository.VendaRepository;
import com.rlouro.vendaservice.service.ICashbackService;
import com.rlouro.vendaservice.service.IVendaService;

@Service
public class VendaService extends BaseService implements IVendaService {

	private final VendaRepository vendaRepository;

	private final ICashbackService cashbackService;

	@Inject
	public VendaService(VendaRepository vendaRepository, ICashbackService cashbackService) {
		super(new ModelMapper());
		this.vendaRepository = vendaRepository;
		this.cashbackService = cashbackService;
	}

	@Override
	public VendaDTO save(VendaDTO dto) {
		Venda entity = modelMapper.map(dto, Venda.class);
		entity = vendaRepository.save(entity);

		return toVendaDTO(entity);
	}

	@Override
	public VendaDTO findById(Long id) {
		Validate.notNull(id, GET_ID_NAO_INFORMADO_MESSAGE);

		Optional<Venda> opEntity = vendaRepository.findById(id);

		if (opEntity.isPresent()) {
			return toVendaDTO(opEntity.get());
		} else {
			return null;
		}
	}

	@Override
	public Page<VendaBasicDTO> findByFilter(VendaFilter filter) {
		validaFilter(filter);
		Validate.notNull(filter.getInicio(), GET_FILTRO_NAO_PREENCHIDO_MESSAGE);
		Validate.notNull(filter.getFim(), GET_FILTRO_NAO_PREENCHIDO_MESSAGE);

		Pageable pageable = PageRequest.of(filter.getPage(), filter.getLimit(),
				Sort.by(Order.desc("dataVenda"), Order.asc("id")));

		Page<Venda> entityPage = vendaRepository.findByDataVendaBetween(filter.getInicio(), filter.getFim(), pageable);

		List<VendaBasicDTO> dtoList = new ArrayList<>();

		for (Venda venda : entityPage) {
			dtoList.add(modelMapper.map(venda, VendaBasicDTO.class));
		}

		return new PageImpl<>(dtoList, pageable, entityPage.getTotalElements());
	}

	private VendaDTO toVendaDTO(Venda entity) {
		VendaDTO dto = modelMapper.map(entity, VendaDTO.class);

		for (ItemVenda item : entity.getItemList()) {
			dto.getDiscos().add(modelMapper.map(item.getDisco(), DiscoBasicDTO.class));
		}

		return dto;
	}

}
