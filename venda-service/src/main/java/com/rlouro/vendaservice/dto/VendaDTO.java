package com.rlouro.vendaservice.dto;

import java.util.ArrayList;
import java.util.List;

public class VendaDTO extends VendaBasicDTO {

	private List<DiscoBasicDTO> itemList = new ArrayList<>();

	public List<DiscoBasicDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoBasicDTO> itemList) {
		this.itemList = itemList;
	}

}
