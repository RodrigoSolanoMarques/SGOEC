package br.edu.utfpr.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class IndexController {
	
	
	@RequestMapping("index")
	public String home(){
		return "index";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("teste")
	public String teste(){
		return "teste";
	}
}
