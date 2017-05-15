package com.banking.emprestimos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.emprestimos.model.Emprestimo;
import com.banking.emprestimos.model.Parcela;
import com.banking.emprestimos.repository.Emprestimos;

@Service
public class EmprestimoService {

	@Autowired
	private Emprestimos emprestimos;

	Emprestimo emprestimo;
	ArrayList<Parcela> parcela;

	@Transactional
	public void salvar(Emprestimo emprestimo) {

		Double a = emprestimo.getValorSolicitado();
		Double b = emprestimo.getPercentual();
		Double c = (a + (a * b/100));
		emprestimo.setValorEmprestado(c);
		
		

		
		
		
		
		
		
		
		
		emprestimos.save(emprestimo);
	}

}
