package com.banking.emprestimos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private Integer nParcela;
	
	@DateTimeFormat(pattern="dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@NumberFormat(pattern = "#,##0.00")
	private Double valorParcela;

	@Embedded
	StatusParcela statusParcela;
	
//	----------------------------- RELACIONAMENTOS -----------------------------

	@JoinColumn
	@ManyToOne
	private Emprestimo emprestimo;
	
		
}
