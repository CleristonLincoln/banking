package com.banking.emprestimos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double valorParcela;

	
	private String obs;
	
	
	
	@ManyToOne
	@JoinColumn(name="emprestimo_id")
	private Emprestimo emprestimo;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;


	public Emprestimo getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


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


		
	
	
	
}
