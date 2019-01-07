package com.rlouro.vendaservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_VENDA")
public class ItemVenda {

	@JoinColumn(name = "VE_ID", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Venda venda;

	@JoinColumn(name = "DI_ID", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Disco disco;

	@Column(name = "IV_VL_CASHBACK", nullable = false)
	private Double cashback;

}
