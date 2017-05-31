package com.banking.emprestimos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.emprestimos.model.Cliente;
import com.banking.emprestimos.repository.Clientes;

@Service
public class ClienteService {

	@Autowired
	private Clientes clientes;
	
	
	@Transactional
	public void salvar(Cliente cliente){
		
		
		
		clientes.save(cliente);
		
	}
}
