package com.banking.emprestimos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/novo")
	public String view(){
		return "/Home";
	}
	
}
