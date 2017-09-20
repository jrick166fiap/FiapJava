package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.model.Paciente;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	
	@Autowired 
	private PacienteDAO dao;
	
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		return new ModelAndView("paciente/cadastro").addObject("paciente",new Paciente());
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processForm(Paciente paicente,RedirectAttributes redirect){
		
		ModelAndView retorno;
		
		dao.cadastrar(paicente);
		
		redirect.addFlashAttribute("msg","Cadastrado com Sucesso");
		retorno = new ModelAndView("redirect:/paciente/listar");
		return retorno;
		
	}
	@GetMapping("listar")
	public ModelAndView listarForm(){
		
		ModelAndView retorno = new ModelAndView("paciente/lista");
		retorno.addObject("listao",dao.listar());
		return retorno;
		
		
	}

}
