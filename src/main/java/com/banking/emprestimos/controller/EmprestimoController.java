package com.banking.emprestimos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.banking.emprestimos.model.Cliente;
import com.banking.emprestimos.model.Emprestimo;
import com.banking.emprestimos.repository.Clientes;
import com.banking.emprestimos.repository.Emprestimos;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private Clientes clientes;

	@Autowired
	private Emprestimos emprestimos;
	
	


	@RequestMapping("/novo")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView("/Emprestimo");
		mv.addObject(new Emprestimo());
		mv.addObject("clientes", clientes.findAll());

		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Emprestimo emprestimo) {
		
		ModelAndView mv = new ModelAndView("/Emprestimo");
		emprestimos.save(emprestimo);
		System.out.println("Salvo>>>>>>>" + emprestimo);
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Emprestimo> todosEmprestimos = emprestimos.findAll();
		List<Cliente> todosClientes = clientes.findAll();
		ModelAndView mv = new ModelAndView("EmprestimoFollowup");
		mv.addObject("emprestimos", todosEmprestimos);
		mv.addObject("clientes", todosClientes);
	
		return mv;
	}
}
