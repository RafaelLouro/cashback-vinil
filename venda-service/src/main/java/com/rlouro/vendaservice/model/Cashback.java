package com.rlouro.vendaservice.model;

import java.io.Serializable;
import java.time.DayOfWeek;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CASHBACK")
public class Cashback implements Serializable {

    private static final long serialVersionUID = 2066603960607520531L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CB_ID")
    private Long id;

    @Size(max = 10)
    @Enumerated(value = EnumType.STRING)
    @Column(name = "CB_IN_DIA", nullable = false)
    private DayOfWeek diaSemana;

    @Column(name = "CB_VL_PORCENTAGEM", nullable = false)
    private Double porcentagem;

    @JoinColumn(name = "GE_ID", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Genero genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Cashback() {
    }

    public Cashback(Long id, @Size(max = 10) DayOfWeek diaSemana, Double porcentagem, Genero genero) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.porcentagem = porcentagem;
        this.genero = genero;
    }
}
