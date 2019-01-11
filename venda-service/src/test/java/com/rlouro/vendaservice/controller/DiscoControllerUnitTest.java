package com.rlouro.vendaservice.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rlouro.vendaservice.BaseUnitTest;
import com.rlouro.vendaservice.dto.DiscoDTO;
import com.rlouro.vendaservice.filter.DiscoFilter;
import com.rlouro.vendaservice.service.IDiscoService;

@WebMvcTest(value = DiscoController.class)
public class DiscoControllerUnitTest extends BaseUnitTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IDiscoService discoService;

	private static final Long ID_TEST = Long.valueOf(1);

	private DiscoDTO dto;

	@Before
	public void setup() {
		dto = new DiscoDTO();
		dto.setId(ID_TEST);
		dto.setNome("cd1");
		dto.setNomeGenero("pop");
	}

	@Test
	public void finbByIdDiscoIdValido() throws Exception {
		Mockito.when(discoService.findById(Mockito.anyLong())).thenReturn(dto);

		mvc.perform(MockMvcRequestBuilders.get("/disco/" + ID_TEST).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", equalTo(dto.getId().intValue())));
	}

	@Test
	public void finbByIdDiscoIdInvalido() throws Exception {
		Mockito.when(discoService.findById(Mockito.anyLong())).thenReturn(null);

		mvc.perform(MockMvcRequestBuilders.get("/disco/" + ID_TEST).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").doesNotExist());
	}

	@Test
	public void findByFilterValido() throws Exception {
		Mockito.when(discoService.findByFilter(Mockito.any(DiscoFilter.class)))
				.thenReturn(new PageImpl<>(Arrays.asList(dto)));

		mvc.perform(MockMvcRequestBuilders.get("/disco/").param("page", "0").param("limit", "10")
				.param("generoId", ID_TEST.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.content", hasSize(1)));
	}

}
