package com.rlouro.vendaservice.service.impl;

import org.apache.commons.lang.Validate;
import org.modelmapper.ModelMapper;
import com.rlouro.vendaservice.filter.PageableFilter;

public abstract class BaseService {

    public static final String GET_ID_NAO_INFORMADO_MESSAGE = "O id deve ser informado.";
    public static final String GET_FILTRO_NULL_MESSAGE = "O filtro não pode ser nulo.";
    public static final String GET_FILTRO_NAO_PREENCHIDO_MESSAGE = "Todos os parâmetros do filtro devem ser informados.";
    protected final ModelMapper modelMapper;

    protected BaseService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected void validaFilter(PageableFilter filter) {
        Validate.notNull(filter, GET_FILTRO_NULL_MESSAGE);
        Validate.notNull(filter.getPage(), GET_FILTRO_NAO_PREENCHIDO_MESSAGE);
        Validate.notNull(filter.getLimit(), GET_FILTRO_NAO_PREENCHIDO_MESSAGE);
    }

}
