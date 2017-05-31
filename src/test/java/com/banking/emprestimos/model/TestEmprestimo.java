package com.banking.emprestimos.model;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Getter;
import lombok.Setter;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestEmprestimo {

	@Autowired
	EntityManager entityManeger;
	
	@Autowired
	@Getter @Setter
	Emprestimo emprestimo;
	
	@Autowired
	@Getter @Setter
	Parcela parcela;
	
	
	@Test
	public void salvarParcela(){
		
		Parcela p = new Parcela();
		
		p.setValorParcela(234.00);
		p.setNParcela(2);
		
		//emprestimo.setListaParcelas();
		
		Parcela p1 = new Parcela();
		
		p1.setValorParcela(12.21);
		p1.setNParcela(4);
	}
	
	
	
}
