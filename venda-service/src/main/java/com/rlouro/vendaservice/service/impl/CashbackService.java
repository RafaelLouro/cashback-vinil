package com.rlouro.vendaservice.service.impl;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rlouro.vendaservice.model.Cashback;
import com.rlouro.vendaservice.repository.CashbackRepository;
import com.rlouro.vendaservice.service.ICashbackService;

@Service
public class CashbackService implements ICashbackService {

	private final CashbackRepository cashbackRepository;

	@Inject
	public CashbackService(CashbackRepository cashbackRepository) {
		this.cashbackRepository = cashbackRepository;
	}

	@Override
	public Cashback findByGeneroId(Long generoId) {
		return cashbackRepository.findByGeneroIdAndDiaSemana(generoId, LocalDateTime.now().getDayOfWeek());
	}

}
