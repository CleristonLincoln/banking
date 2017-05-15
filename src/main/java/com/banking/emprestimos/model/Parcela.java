package com.banking.emprestimos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double valorParcela;

	// total de parcelas que ainda falta receber
	@Column(name = "parcelas_a_receber")
	private Integer parcelasAReceber;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
    private Date dataParcela;

	private String obs;
	
	
	// situação do recebimento da parcela
	@Enumerated(EnumType.STRING)
	private StatusParcela statusParcela;
	
	@ManyToOne
	@JoinColumn(name="emprestimo_id")
	private Emprestimo emprestimo;
	
	
		
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Integer getParcelasAReceber() {
		return parcelasAReceber;
	}
	public void setParcelasAReceber(Integer parcelasAReceber) {
		this.parcelasAReceber = parcelasAReceber;
	}
	public Date getDataParcela() {
		return dataParcela;
	}
	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public StatusParcela getStatusParcela() {
		return statusParcela;
	}
	public void setStatusParcela(StatusParcela statusParcela) {
		this.statusParcela = statusParcela;
	}
	
	
	
}
