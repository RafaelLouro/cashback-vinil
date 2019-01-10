package com.rlouro.vendaservice.service;

import com.rlouro.vendaservice.model.Cashback;

public interface ICashbackService {

	Cashback findByGeneroId(Long generoId);

}
