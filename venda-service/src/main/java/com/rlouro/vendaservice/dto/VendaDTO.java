package com.rlouro.vendaservice.dto;

import java.util.ArrayList;
import java.util.List;

public class VendaDTO extends VendaBasicDTO {

	private List<DiscoBasicDTO> discos = new ArrayList<>();

	public List<DiscoBasicDTO> getDiscos() {
		return discos;
	}

	public void setDiscos(List<DiscoBasicDTO> discos) {
		this.discos = discos;
	}

}
