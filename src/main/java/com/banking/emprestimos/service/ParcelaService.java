package com.banking.emprestimos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.emprestimos.model.Emprestimo;
import com.banking.emprestimos.model.Parcela;
import com.banking.emprestimos.repository.Parcelas;

@Service
public class ParcelaService {

	@Autowired
	private Parcelas parcelas;
	
	
	
	@Transactional
	public void salvar(Parcela parcela){
		
		
		parcelas.save(parcela);
		
	}
	
	
		
}
