package com.banking.emprestimos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.emprestimos.model.Emprestimo;
import com.banking.emprestimos.repository.Emprestimos;

@Service
public class EmprestimoService {

	@Autowired
	private Emprestimos emprestimos;
	
	
	@Transactional
	public void salvar(Emprestimo emprestimo){
		emprestimos.save(emprestimo);
	}
	
}
