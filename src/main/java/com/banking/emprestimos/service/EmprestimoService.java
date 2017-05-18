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

	

	@Transactional
	public void salvar(Emprestimo emprestimo, Parcela parcela) {

		// calcula o valor a receber
		Double a = emprestimo.getValorSolicitado();
		Double b = emprestimo.getPercentual();
		Double c = (a + (a * b / 100));

		emprestimo.setValorEmprestado(c);
		// http://www.willianparige.com.br/2015/12/java-spring-mvc-jsp-salvando-uma-lista.html?m=1

		List<Parcela> parcelaList= new ArrayList<Parcela>();
		
		parcelaList.add(parcela);
		
		emprestimos.save(emprestimo);

	}

}
