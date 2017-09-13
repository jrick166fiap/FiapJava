package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PratoController {
	
	@RequestMapping("prato")
	public String prato(){
		return "prato/index";	
	}
	
	@RequestMapping("prato/cadastro")
	public String abrirForm(){
		
		return "prato/cadastro";
	}
	@RequestMapping(value="prato/cadastrar",method=RequestMethod.POST)
	public String processarForm(String nome,double preco,float peso){
		System.out.println(nome+" "+preco+""+peso);
		return "prato/cadastro";
		
	}
	
}
