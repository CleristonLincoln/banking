package com.banking.emprestimos.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	//valor solicitado
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "99999.99", message = "Valor não pode ser maior que 99999.99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorEmprestimo;

	//valor com o acrescimo dos juros
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorTotal;
	
	
	//data em que o dinheiro foi entregue
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;

	//data em que deve ser pago a primeira parcela
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date primeiraEmprestimo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	//valor de cada parcela
	private BigDecimal valorParcela;

	//situação do recebimento da parcela
	@Enumerated(EnumType.STRING)
	private StatusParcela statusParcela;

	//percentual de juros que será aplicado ao valor inicial
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal percentual;

	
	//total de parcelas que será o financiamento
	private Integer totalParcelas;

	//numero de parcelas que foram pagas
	private Integer parcelasPagas;
	
	//total de parcelas que ainda falta receber
	@Column(name="parcelas_a_pagar")
	private Integer parcelasAPagar;
	
	
	//alguma anotação no financiamento
	private String anotacao;
	
	
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	

	

	public Integer getTotalParcelas() {
		return totalParcelas;
	}

	public void setTotalParcelas(Integer totalParcelas) {
		this.totalParcelas = totalParcelas;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusParcela getStatusParcela() {
		return statusParcela;
	}

	public void setStatusParcela(StatusParcela statusParcela) {
		this.statusParcela = statusParcela;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public Integer getParcelasAPagar() {
		return parcelasAPagar;
	}

	public void setParcelasAPagar(Integer parcelasAPagar) {
		this.parcelasAPagar = parcelasAPagar;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
}
