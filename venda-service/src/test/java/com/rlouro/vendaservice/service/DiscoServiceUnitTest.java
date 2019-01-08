package com.rlouro.vendaservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.model.Disco;
import com.rlouro.vendaservice.model.Genero;
import com.rlouro.vendaservice.repository.DiscoRepository;
import com.rlouro.vendaservice.service.impl.DiscoService;

public class DiscoServiceUnitTest extends BaseUnitTest {

	@InjectMocks
	private DiscoService discoService;

	@Mock
	private DiscoRepository discoRepository;

	private Disco disco;

	@Before
	public void setup() {
		disco = new Disco();
		disco.setId(ID_TEST);
		disco.setNome("test1");
		disco.setPreco(10.0);
		disco.setGenero(new Genero(ID_TEST, "Genero 1"));
	}

	@Test
	public void saveDiscoValido() {
		Mockito.when(discoRepository.save(Mockito.any(Disco.class))).thenReturn(disco);

		DiscoDTO returned = discoService.save(new DiscoDTO());

		assertNotNull(returned);
		assertNotNull(returned.getId());
		assertEquals(disco.getGenero().getNome(), returned.getGenero());
		
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
		exception.expectMessage(discoService.GET_ID_NAO_INFORMADO_MESSAGE);

		discoService.findById(null);
	}

}
