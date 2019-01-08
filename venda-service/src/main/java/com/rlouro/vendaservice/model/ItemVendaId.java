package com.rlouro.vendaservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemVendaId implements Serializable {

	private static final long serialVersionUID = 369432212772358574L;

	@Column(name = "VE_ID", nullable = false)
	private Long vendaId;

	@Column(name = "DI_ID", nullable = false)
	private Long discoId;

	public Long getVendaId() {
		return vendaId;
	}

	public void setVendaId(Long vendaId) {
		this.vendaId = vendaId;
	}

	public Long getDiscoId() {
		return discoId;
	}

	public void setDiscoId(Long discoId) {
		this.discoId = discoId;
	}

}
