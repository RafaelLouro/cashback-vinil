package com.rlouro.vendaservice.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.rlouro.vendaservice.BaseUnitTest;
import com.rlouro.vendaservice.dto.VendaDTO;
import com.rlouro.vendaservice.filter.VendaFilter;
import com.rlouro.vendaservice.service.IVendaService;

@WebMvcTest(value = VendaController.class)
public class VendaControllerUnitTest extends BaseUnitTest {

    @Inject
    private MockMvc mvc;

    @MockBean
    private IVendaService vendaService;

    private static final Long ID_TEST = Long.valueOf(1);

    private VendaDTO dto;

    @Before
    public void setup() {
        dto = new VendaDTO();
        dto.setId(ID_TEST);
        dto.setDataVenda(LocalDateTime.now());
        dto.setCashbackTotal(10.0);
        dto.setTotal(100.0);
    }

    @Test
    public void saveVendaValida() throws Exception {
        Mockito.when(vendaService.save(Mockito.any(VendaDTO.class))).thenReturn(dto);

        mvc.perform(MockMvcRequestBuilders.post("/venda").contentType(MediaType.APPLICATION_JSON).content(
                convertObjectToJsonBytes(dto))).andExpect(status().isCreated()).andExpect(
                        jsonPath("$.id", notNullValue()));
    }

    @Test
    public void finbByIdVendaIdValido() throws Exception {
        Mockito.when(vendaService.findById(Mockito.anyLong())).thenReturn(dto);

        mvc.perform(MockMvcRequestBuilders.get("/venda/" + ID_TEST).contentType(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(jsonPath("$.id", equalTo(dto.getId().intValue())));
    }

    @Test
    public void finbByIdVendaIdInvalido() throws Exception {
        Mockito.when(vendaService.findById(Mockito.anyLong())).thenReturn(null);

        mvc.perform(MockMvcRequestBuilders.get("/venda/" + ID_TEST).contentType(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void findByFilterValido() throws Exception {
        Mockito.when(vendaService.findByFilter(Mockito.any(VendaFilter.class))).thenReturn(
                new PageImpl<>(Arrays.asList(dto)));

        mvc.perform(MockMvcRequestBuilders.get("/venda/").param("page", "0").param("limit", "10").param("inicio",
                LocalDateTime.now().toString()).param("fim", LocalDateTime.now().toString()).contentType(
                        MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
                                jsonPath("$.content", hasSize(1)));
    }

}
