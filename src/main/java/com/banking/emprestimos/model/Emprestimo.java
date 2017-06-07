package com.banking.emprestimos.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDate dataEmprestimo;

	// data em que deve ser pago a primeira parcela
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDate primeiraEmprestimo;

	// percentual de juros que será aplicado ao valor inicial
	@NumberFormat(pattern = "#,##0.00")
	private Double percentual;

	// alguma anotação no financiamento
	private String anotacao;


	private Integer nParcelas;

	private Integer pPEmprestimo; //periodicidade em que o emprestimo será pago.

	

	
//	----------------------------- RELACIONAMENTOS -----------------------------
	
	@ManyToOne
	private Cliente cliente;

	
		
	// um emprestimo tem varias parcelas
	// So essa basta não precisara ser bidirecional
	@OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
	private List<Parcela> listaParcelas;


		
	
}