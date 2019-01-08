package com.rlouro.vendaservice.dto;

import java.time.LocalDateTime;

public class VendaBasicDTO {

	private Long id;

	private LocalDateTime inicio;

	private LocalDateTime fim;

	private Double cashbackTotal;

	private Double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
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
