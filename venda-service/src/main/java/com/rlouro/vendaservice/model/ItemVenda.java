package com.rlouro.vendaservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_VENDA")
public class ItemVenda implements Serializable {

	private static final long serialVersionUID = 5469634871692421473L;

	@EmbeddedId
	private ItemVendaId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId(value = "vendaId")
	private Venda venda;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId(value = "discoId")
	private Disco disco;

	@Column(name = "IV_VL_CASHBACK", nullable = false)
	private Double cashback;

	public ItemVendaId getId() {
		return id;
	}

	public void setId(ItemVendaId id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	public Double getCashback() {
		return cashback;
	}

	public void setCashback(Double cashback) {
		this.cashback = cashback;
	}

}
