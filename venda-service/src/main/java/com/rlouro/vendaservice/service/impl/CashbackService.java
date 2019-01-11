package com.rlouro.vendaservice.service.impl;

import java.time.LocalDateTime;
import javax.inject.Inject;
import org.apache.commons.lang.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rlouro.vendaservice.model.Cashback;
import com.rlouro.vendaservice.repository.CashbackRepository;
import com.rlouro.vendaservice.service.ICashbackService;

@Service
@Transactional(readOnly = true)
public class CashbackService extends BaseService implements ICashbackService {

    private final CashbackRepository cashbackRepository;

    @Inject
    public CashbackService(CashbackRepository cashbackRepository) {
        super(new ModelMapper());
        this.cashbackRepository = cashbackRepository;
    }

    @Override
    public Cashback findByGeneroId(Long generoId) {
        Validate.notNull(generoId, GET_ID_NAO_INFORMADO_MESSAGE);
        return cashbackRepository.findByGeneroIdAndDiaSemana(generoId, LocalDateTime.now().getDayOfWeek());
    }

}
