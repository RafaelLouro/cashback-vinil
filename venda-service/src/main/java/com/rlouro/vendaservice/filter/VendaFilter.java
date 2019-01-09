package com.rlouro.vendaservice.filter;

import java.time.LocalDateTime;

public class VendaFilter extends PageableFilter {

	private LocalDateTime inicio;

	private LocalDateTime fim;

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

}
