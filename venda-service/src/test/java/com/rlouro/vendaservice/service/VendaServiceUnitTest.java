package com.rlouro.vendaservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.rlouro.vendaservice.BaseUnitTest;
import com.rlouro.vendaservice.dto.DiscoBasicDTO;
import com.rlouro.vendaservice.dto.VendaBasicDTO;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.model.ItemVenda;
import com.rlouro.vendaservice.model.ItemVendaId;
import com.rlouro.vendaservice.model.Venda;
import com.rlouro.vendaservice.repository.VendaRepository;
import com.rlouro.vendaservice.service.impl.BaseService;
import com.rlouro.vendaservice.service.impl.VendaService;

public class VendaServiceUnitTest extends BaseUnitTest {

    @InjectMocks
    private VendaService vendaService;

    @Mock
    private VendaRepository vendaRepository;

    private Venda venda;

    private VendaFilter filter;

    @Before
    public void setup() {
        ItemVenda itemVenda = new ItemVenda(new ItemVendaId(ID_TEST, ID_TEST), venda,
                new Disco(ID_TEST, "disco1", 10.0, null), 10.0);
        List<ItemVenda> itemList = new ArrayList<>();
        itemList.add(itemVenda);
        venda = new Venda(ID_TEST, LocalDateTime.now(), 10.0, 10.0, itemList);

        filter = new VendaFilter();
        filter.setPage(0);
        filter.setLimit(10);
    }

    @Test
    public void saveDiscoValido() {
        Mockito.when(vendaRepository.save(Mockito.any(Venda.class))).thenReturn(venda);

        VendaDTO returned = vendaService.save(new VendaDTO());

        assertNotNull(returned);
        assertNotNull(returned.getId());
        assertEquals(1, returned.getDiscos().size());

        Disco disco = venda.getItemList().get(0).getDisco();
        DiscoBasicDTO dtoDisco = returned.getDiscos().get(0);
        assertEquals(disco.getNome(), dtoDisco.getNome());
    }

    @Test
    public void findByIdDiscoIdValido() {
        Mockito.when(vendaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(venda));

        VendaDTO returned = vendaService.findById(ID_TEST);

        assertNotNull(returned);
    }

    @Test
    public void findByIdDiscoIdInvalido() {
        Mockito.when(vendaRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        VendaDTO returned = vendaService.findById(ID_TEST);

        assertNull(returned);
    }

    @Test
    public void findByIdDiscoIdNulo() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_ID_NAO_INFORMADO_MESSAGE);

        vendaService.findById(null);
    }

    @Test
    public void findByFilterValido() {
        Mockito.when(vendaRepository.findByDataVendaBetween(Mockito.any(LocalDateTime.class),
                Mockito.any(LocalDateTime.class), Mockito.any(PageRequest.class))).thenReturn(
                        new PageImpl<>(Arrays.asList(venda)));

        filter.setInicio(LocalDateTime.now());
        filter.setFim(LocalDateTime.now().plusDays(1));

        Page<VendaBasicDTO> returnedPage = vendaService.findByFilter(filter);

        assertNotNull(returnedPage);
        assertFalse(returnedPage.isEmpty());
        assertEquals(1, returnedPage.getContent().size());
    }

    @Test
    public void findByFilterInvalido() {
        Mockito.when(vendaRepository.findByDataVendaBetween(Mockito.any(LocalDateTime.class),
                Mockito.any(LocalDateTime.class), Mockito.any(PageRequest.class))).thenReturn(
                        new PageImpl<>(new ArrayList<>()));

        filter.setInicio(LocalDateTime.now());
        filter.setFim(LocalDateTime.now().plusDays(1));

        Page<VendaBasicDTO> returnedPage = vendaService.findByFilter(filter);

        assertNotNull(returnedPage);
        assertTrue(returnedPage.isEmpty());
    }

    @Test
    public void findByFilterPreenchimentoInvalido() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_FILTRO_NAO_PREENCHIDO_MESSAGE);

        vendaService.findByFilter(filter);
    }

    @Test
    public void findByFilterNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_FILTRO_NULL_MESSAGE);

        vendaService.findByFilter(null);
    }

}
