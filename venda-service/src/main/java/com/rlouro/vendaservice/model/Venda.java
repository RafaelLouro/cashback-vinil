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

	@Column(name = "VE_DT_VENDA", nullable = false)
	private LocalDateTime dataVenda;

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

	public List<ItemVenda> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemVenda> itemList) {
		this.itemList = itemList;
	}

	public Venda() {
	}

	public Venda(Long id, LocalDateTime dataVenda, Double cashbackTotal, Double total, List<ItemVenda> itemList) {
		super();
		this.id = id;
		this.dataVenda = dataVenda;
		this.cashbackTotal = cashbackTotal;
		this.total = total;
		this.itemList = itemList;
	}

}
