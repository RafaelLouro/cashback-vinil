package com.rlouro.vendaservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {

	private static final long serialVersionUID = 324722852598849409L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VE_ID")
	private Long id;

	@Column(name = "VE_DT_INICIO", nullable = false)
	private LocalDateTime inicio;

	@Column(name = "VE_DT_FIM")
	private LocalDateTime fim;

	@Column(name = "VE_VL_CASHBACK", nullable = false)
	private Double cashbackTotal;

	@Column(name = "VE_VL_TOTAL", nullable = false)
	private Double total;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
	private List<ItemVenda> itemList = new ArrayList<>();

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

	public List<ItemVenda> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemVenda> itemList) {
		this.itemList = itemList;
	}

}
