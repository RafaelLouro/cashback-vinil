package com.rlouro.vendaservice.service.impl;

import org.modelmapper.ModelMapper;

public abstract class BaseService {

	public static final String GET_ID_NAO_INFORMADO_MESSAGE = "O id deve ser informado.";
	protected final ModelMapper modelMapper;

	protected BaseService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
