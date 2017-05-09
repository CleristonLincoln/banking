package com.banking.emprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.emprestimos.model.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long> {

}
