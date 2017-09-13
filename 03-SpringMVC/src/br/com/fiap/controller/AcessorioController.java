package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.AcessorioDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Acessorio;


@Controller
@RequestMapping("/acessorio")
public class AcessorioController {
	
	
	@Autowired
	private AcessorioDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		
		return new ModelAndView("acessorio/cadastro").addObject("acessorio",new Acessorio());
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processaForm(Acessorio acessorio,RedirectAttributes redirect){
		
		dao.cadastrar(acessorio);
		
		redirect.addFlashAttribute("msg","Cadastrado com Sucesso");
		return new ModelAndView("redirect:/acessorio/listar");
		
	}
	
	@GetMapping("listar")
	public ModelAndView listaForm(){
		
		ModelAndView retorno = new ModelAndView("acessorio/lista");
		retorno.addObject("listao",dao.listar());
		return retorno;
		
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirForm(@PathVariable("id") int id){
		
		Acessorio acessorio = dao.pesquisar(id);
		ModelAndView retorno = new ModelAndView("acessorio/editar");
		retorno.addObject("acessorio",acessorio);
		
		return retorno;
		
	}
	
	@PostMapping("editar")
	@Transactional
	public ModelAndView processForm(Acessorio acessorio,RedirectAttributes redirect){
		
		dao.alterar(acessorio);
		redirect.addFlashAttribute("msg","Alterado com Sucesso");
		
		return new ModelAndView("redirect:/acessorio/listar");	
	}
	
	@PostMapping("remover")
	@Transactional
	public ModelAndView processForm(int codigo,RedirectAttributes redirect){
		
		try {
			dao.remover(codigo);
			redirect.addFlashAttribute("msg","Removido com Sucesso");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ModelAndView("redirect:/acessorio/listar");	
	}
	

}
