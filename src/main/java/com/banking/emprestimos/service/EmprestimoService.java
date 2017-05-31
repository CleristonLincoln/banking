package com.banking.emprestimos.service;

import java.util.ArrayList;

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
	

	private Parcela p = new Parcela();
	
	@Transactional
	public void salvarEmprestimo(Emprestimo emprestimo){
		
		Double a = emprestimo.getValorSolicitado();//valor que esta pedindo
		Double b = emprestimo.getPercentual();//percentualde juros sobre o valor emprestado
		Double c = (a + (a * b / 100));//valor total que deverá ser pago
		
		emprestimo.setValorEmprestado(c);//salva o valor a ser cobrado
	
		
		
			gerarPrcelas(emprestimo);
		emprestimos.save(emprestimo);
		
		
	}
	
	
	public void gerarPrcelas(Emprestimo emprestimo) {

		ArrayList<Parcela> parcelas = new ArrayList<>();

		int nParcelas = emprestimo.getNParcelas();
		double valorParcelas = emprestimo.getValorEmprestado() / nParcelas;
		for (int i = 0; i < nParcelas; i++) {
			p.setNParcela(i);
			p.setValorParcela(valorParcelas);
			p.setEmprestimo(emprestimo);

			parcelas.add(p);
			p = new Parcela();
		}
		emprestimo.setListaParcelas(parcelas);

	}
	
	
}
