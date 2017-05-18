package com.banking.emprestimos.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Emprestimo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// valor solicitado
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "99999.99", message = "Valor não pode ser maior que 99999.99")
	@NumberFormat(pattern = "#,##0.00")
	private Double valorSolicitado;

	// valor com o acrescimo dos juros, valor total a receber
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private Double valorEmprestado;

	// data em que o dinheiro foi entregue
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;

	// data em que deve ser pago a primeira parcela
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date primeiraEmprestimo;

	// percentual de juros que será aplicado ao valor inicial
	@NumberFormat(pattern = "#,##0.00")
	private Double percentual;

	// alguma anotação no financiamento
	private String anotacao;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private Integer nParcelas;
	
	private Double valorParcela;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
    private Date dataParcela;
	
	//um emprestimo tem varias parcelas
	//So essa basta não precisara ser bidirecional
	@OneToMany(mappedBy="emprestimo")
	private List<Parcela> parcelaList;
			
	
	public void adicionarParcelas(List<Parcela> parcelaList){
		
		this.parcelaList = parcelaList;
		
		
	}
	
	
	public Integer getnParcelas() {
		return nParcelas;
	}
	public void setnParcelas(Integer nParcelas) {
		this.nParcelas = nParcelas;
	}
	public List<Parcela> getParcelaList() {
		return parcelaList;
	}
	public void setParcelaList(List<Parcela> parcelaList) {
		this.parcelaList = parcelaList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(Double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	public Double getValorEmprestado() {
		return valorEmprestado;
	}
	public void setValorEmprestado(Double valorEmprestado) {
		this.valorEmprestado = valorEmprestado;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getPrimeiraEmprestimo() {
		return primeiraEmprestimo;
	}
	public void setPrimeiraEmprestimo(Date primeiraEmprestimo) {
		this.primeiraEmprestimo = primeiraEmprestimo;
	}
	public Double getPercentual() {
		return percentual;
	}
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Date getDataParcela() {
		return dataParcela;
	}
	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}

}
