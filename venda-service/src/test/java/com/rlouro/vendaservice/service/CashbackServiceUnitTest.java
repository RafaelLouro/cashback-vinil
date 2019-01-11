package com.rlouro.vendaservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.time.DayOfWeek;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.rlouro.vendaservice.BaseUnitTest;
import com.rlouro.vendaservice.model.Cashback;
import com.rlouro.vendaservice.repository.CashbackRepository;
import com.rlouro.vendaservice.service.impl.BaseService;
import com.rlouro.vendaservice.service.impl.CashbackService;

public class CashbackServiceUnitTest extends BaseUnitTest {

    @InjectMocks
    private CashbackService cashbackService;

    @Mock
    private CashbackRepository cashbackRepository;

    private Cashback cashback;

    @Before
    public void setup() {
        cashback = new Cashback(ID_TEST, DayOfWeek.SUNDAY, 0.1, null);
    }

    @Test
    public void findByGeneroIdValido() {
        Mockito.when(cashbackRepository.findByGeneroIdAndDiaSemana(Mockito.anyLong(),
                Mockito.any(DayOfWeek.class))).thenReturn(cashback);

        Cashback returned = cashbackService.findByGeneroId(ID_TEST);

        assertNotNull(returned);
    }

    @Test
    public void findByGeneroIdInvalido() {
        Mockito.when(cashbackRepository.findByGeneroIdAndDiaSemana(Mockito.anyLong(),
                Mockito.any(DayOfWeek.class))).thenReturn(null);

        Cashback returned = cashbackService.findByGeneroId(ID_TEST);

        assertNull(returned);
    }

    @Test
    public void findByGeneroIdNulo() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_ID_NAO_INFORMADO_MESSAGE);

        cashbackService.findByGeneroId(null);
    }

}
