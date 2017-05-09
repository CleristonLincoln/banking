package com.banking.emprestimos.model;

public enum StatusCliente {
	LIBERADO("Liberado"), 
	CANCELADO("Cancelado"), 
	EM_ANALISE("Em Análise"), 
	BLOQUEADO("Bloqueado");

	
	
	private String descricao;
	
	StatusCliente(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}
