package com.banking.emprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.emprestimos.model.Emprestimo;

@Repository
public interface Emprestimos extends JpaRepository<Emprestimo, Long>{

	
	
	
	
}
