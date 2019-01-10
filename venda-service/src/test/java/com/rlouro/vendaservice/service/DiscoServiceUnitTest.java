package com.rlouro.vendaservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.model.Genero;
import com.rlouro.vendaservice.repository.DiscoRepository;
import com.rlouro.vendaservice.service.impl.BaseService;
import com.rlouro.vendaservice.service.impl.DiscoService;

public class DiscoServiceUnitTest extends BaseUnitTest {

    @InjectMocks
    private DiscoService discoService;

    @Mock
    private DiscoRepository discoRepository;

    private Disco disco;

    private DiscoFilter filter;

    @Before
    public void setup() {
        disco = new Disco(ID_TEST, "test1", 10.0, new Genero(ID_TEST, "Genero 1"));

        filter = new DiscoFilter();
        filter.setPage(0);
        filter.setLimit(10);
    }

    @Test
    public void saveDiscoValido() {
        Mockito.when(discoRepository.save(Mockito.any(Disco.class))).thenReturn(disco);

        DiscoDTO returned = discoService.save(new DiscoDTO());

        assertNotNull(returned);
        assertNotNull(returned.getId());
        assertEquals(disco.getGenero().getNome(), returned.getNomeGenero());

    }

    @Test
    public void findByIdDiscoIdValido() {
        Mockito.when(discoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(disco));

        DiscoDTO returned = discoService.findById(ID_TEST);

        assertNotNull(returned);
    }

    @Test
    public void findByIdDiscoIdInvalido() {
        Mockito.when(discoRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        DiscoDTO returned = discoService.findById(ID_TEST);

        assertNull(returned);
    }

    @Test
    public void findByIdDiscoIdNulo() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_ID_NAO_INFORMADO_MESSAGE);

        discoService.findById(null);
    }

    @Test
    public void findByFilterValido() {
        Mockito.when(discoRepository.findByGeneroId(Mockito.anyLong(), Mockito.any(PageRequest.class))).thenReturn(
                new PageImpl<>(Arrays.asList(disco)));

        filter.setGeneroId(Long.valueOf(ID_TEST));

        Page<DiscoBasicDTO> returnedPage = discoService.findByFilter(filter);

        assertNotNull(returnedPage);
        assertFalse(returnedPage.isEmpty());
        assertEquals(1, returnedPage.getContent().size());
    }

    @Test
    public void findByFilterInvalido() {
        Mockito.when(discoRepository.findByGeneroId(Mockito.anyLong(), Mockito.any(PageRequest.class))).thenReturn(
                new PageImpl<>(new ArrayList<>()));

        filter.setGeneroId(Long.valueOf(-1));

        Page<DiscoBasicDTO> returnedPage = discoService.findByFilter(filter);

        assertNotNull(returnedPage);
        assertTrue(returnedPage.isEmpty());
    }

    @Test
    public void findByFilterPreenchimentoInvalido() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_FILTRO_NAO_PREENCHIDO_MESSAGE);

        discoService.findByFilter(filter);
    }

    @Test
    public void findByFilterNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(BaseService.GET_FILTRO_NULL_MESSAGE);

        discoService.findByFilter(null);
    }

}
