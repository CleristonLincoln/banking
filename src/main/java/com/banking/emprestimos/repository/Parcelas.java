package com.banking.emprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.emprestimos.model.Parcela;

@Repository
public interface Parcelas extends JpaRepository<Parcela, Long> {

	
	
}
