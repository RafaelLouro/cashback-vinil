package com.rlouro.vendaservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import org.springframework.transaction.annotation.Transactional;
import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.repository.DiscoRepository;
import com.rlouro.vendaservice.service.IDiscoService;

@Service
@Transactional(readOnly = true)
public class DiscoService extends BaseService implements IDiscoService {

    private final DiscoRepository discoRepository;

    @Inject
    public DiscoService(DiscoRepository discoRepository) {
        super(new ModelMapper());
        this.discoRepository = discoRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public DiscoDTO save(DiscoDTO dto) {
        Disco entity = modelMapper.map(dto, Disco.class);
        entity = discoRepository.save(entity);

        return modelMapper.map(entity, DiscoDTO.class);
    }

    @Override
    public DiscoDTO findById(Long id) {
        Disco entity = findEntityById(id);

        if (Objects.isNull(entity)) {
            return null;
        }

        return modelMapper.map(entity, DiscoDTO.class);
    }

    @Override
    public Disco findEntityById(Long id) {
        Validate.notNull(id, GET_ID_NAO_INFORMADO_MESSAGE);

        Optional<Disco> opEntity = discoRepository.findById(id);

        if (opEntity.isPresent()) {
            return opEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<DiscoBasicDTO> findByFilter(DiscoFilter filter) {

        validaFilter(filter);
        Validate.notNull(filter.getGeneroId(), GET_FILTRO_NAO_PREENCHIDO_MESSAGE);

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getLimit(),
                Sort.by(Order.asc("nome"), Order.asc("id")));

        Page<Disco> entityPage = discoRepository.findByGeneroId(filter.getGeneroId(), pageable);

        List<DiscoBasicDTO> dtoList = new ArrayList<>();

        for (Disco disco : entityPage) {
            dtoList.add(modelMapper.map(disco, DiscoBasicDTO.class));
        }

        return new PageImpl<>(dtoList, pageable, entityPage.getTotalElements());
    }

}
