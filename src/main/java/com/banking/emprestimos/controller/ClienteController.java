package com.banking.emprestimos.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.banking.emprestimos.model.Cliente;
import com.banking.emprestimos.model.StatusCliente;
import com.banking.emprestimos.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private Clientes clientes;
	
	
	@RequestMapping("/novo")
	public ModelAndView view(){
		ModelAndView mv = new ModelAndView("/Cliente");
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(value="/novo", method=RequestMethod.POST)
	public String salvar(@Valid Cliente cliente, Model model, BindingResult result,
			RedirectAttributes attributes){
		
		
		if(result.hasErrors()){
			model.addAttribute("mensagem", "Erro noformulario");
		
			return "/Cliente";
		}
		
		clientes.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente Salvocom sucesso");
		System.out.println("Salvo>>>>>>>" +cliente);
		return "redirect:/clientes/novo";
		
	}
	
	@ModelAttribute("todosStatusCliente")
	public List<StatusCliente> todosStatusCliente(){
		return Arrays.asList(StatusCliente.values());
	}
	
	
	
	
}
