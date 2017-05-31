package com.banking.emprestimos.repository;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.emprestimos.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestClientes {

	@Autowired
	private Clientes clientes;
	
	@Autowired 
	EntityManager entityManeger;
	
	@Test
	public void salvar(){	
	
	Cliente cli = new Cliente();
	cli.setNome("jão");
	Cliente clienteSalvo = clientes.save(cli);
	Assert.assertNotNull(clienteSalvo.getId());
	
}
	/*
	@Test
	public void testBuscarPorNome(){
		
		Cliente cli = new Cliente("jão", "não ha observação");
		entityManeger.persist(cli);
		Cliente nomeEncontrado = clientes.buscarPorNome("jão");
		
		
		//ja esta importando estaticamente 
		assertThat(nomeEncontrado.getNome()).isEqualTo(cli.getNome());
	}
	
	*/
}
