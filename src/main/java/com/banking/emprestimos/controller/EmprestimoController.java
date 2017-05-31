package com.banking.emprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.banking.emprestimos.model.Emprestimo;
import com.banking.emprestimos.repository.Clientes;
import com.banking.emprestimos.repository.Emprestimos;
import com.banking.emprestimos.service.EmprestimoService;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private Clientes clientes;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@RequestMapping("/novo")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView("/Emprestimo");
		mv.addObject(new Emprestimo());
		mv.addObject("clientes", clientes.findAll());
		return mv;
	}

	@RequestMapping(value="/novo", method = RequestMethod.POST)
	public ModelAndView salvar(Emprestimo emprestimo){
		ModelAndView mv = new ModelAndView("/Home");
		
		emprestimoService.salvarEmprestimo(emprestimo);
		
		System.out.println("Emprestimo Salvo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		return mv;
	}
	
}
