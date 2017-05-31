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

//	@Autowired 
//	private Parcela p;
//	
	
	
	
	
	@Transactional
	public void salvar(Emprestimo emprestimo) {

		// --------------- calcula o valor a receber -------------
		Double a = emprestimo.getValorSolicitado();//valor que esta pedindo
		Double b = emprestimo.getPercentual();//percentualde juros sobre o valor emprestado
		Double c = (a + (a * b / 100));//valor total que deverá ser pago
		int nP = emprestimo.getNParcelas();//numero deparcelas em que o emrpestimo será pago
		emprestimo.setValorEmprestado(c);//salva o valor a ser cobrado
		Double vParcela = c/nP;
	
		// --------------- gerador das parcelas -------------

		
		ArrayList<Parcela> parcelas = new ArrayList<>();
		Parcela p = new Parcela();
		for (int i = 0; i < nP; i++) {
			p.setNParcela(i);
			p.setValorParcela(vParcela);
		
			
			parcelas.add(p);
			p = new Parcela();
		}
		emprestimo.setListaParcelas(parcelas);
	
		

		
		emprestimos.save(emprestimo);

	}

}
