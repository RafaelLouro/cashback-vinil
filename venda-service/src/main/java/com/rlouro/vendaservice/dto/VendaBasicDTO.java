package com.rlouro.vendaservice.dto;

import java.time.LocalDateTime;

public class VendaBasicDTO {

	private Long id;

	private LocalDateTime dataVenda;

	private Double cashbackTotal;

	private Double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getCashbackTotal() {
		return cashbackTotal;
	}

	public void setCashbackTotal(Double cashbackTotal) {
		this.cashbackTotal = cashbackTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
