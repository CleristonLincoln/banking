package com.banking.emprestimos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String anotacao;

	

//	----------------------------- RELACIONAMENTOS -----------------------------

	

	@Enumerated(EnumType.STRING)
	private StatusCliente status;

	@OneToMany(mappedBy = "cliente")
	private List<Emprestimo> emprestimos;

	
	
}
