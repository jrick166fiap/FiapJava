package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.AnimeDAO;
import br.com.fiap.entity.anime.Anime;
import br.com.fiap.exception.IdNotFoundException;

@Controller
@RequestMapping("/anime")
public class AnimeController {
	
	@Autowired
	private AnimeDAO dao;
	
	//private static List<Anime> lista = new ArrayList<>();
	
	@GetMapping("cadastrar")
	public ModelAndView AbrirForm(){
		
		return new ModelAndView("anime/cadastro").addObject("anime",new Anime());
		
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processaForme(Anime anime, RedirectAttributes redirectAttributes){
		//lista.add(anime);
		
		dao.cadastrar(anime);
		System.out.println(anime.getNome()+anime.getPersonagemPrincipal());
		
		
		//ModelAndView retorno = ModelAndView("redirect:/anime/listar");
		redirectAttributes.addFlashAttribute("msg","Cadastrado com Sucesso");
		
		//retorno.addObject("anime",anime); cadastro sem banco
		
		return new ModelAndView("redirect:/anime/listar");
	}
	
	
	@GetMapping("listar")
	public ModelAndView listarForm(){
		
		
		ModelAndView retorno = new ModelAndView("anime/lista");
		retorno.addObject("listao",dao.listar());
		
		return retorno;
		
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarForm(@PathVariable("id") int id){
		
		ModelAndView retorno = new ModelAndView("anime/edicao");
		
		retorno.addObject("anime",dao.pesquisar(id));
		
		return retorno;
	}
	
	@PostMapping("/editar/{id}")
	@Transactional
	public ModelAndView processaForm(@PathVariable("id") int id,Anime anime,RedirectAttributes redirect){
		
		anime.setCodigo(id);
		dao.alterar(anime);
		
		System.out.println(anime.getEpisodios());
		
		redirect.addFlashAttribute("msg","Alterado com Sucesso");
		return new ModelAndView("redirect:/anime/listar");
	} 
	
	@GetMapping("/remover/{id}")
	@Transactional
	public ModelAndView removerForm(@PathVariable("id") int id,RedirectAttributes redirect){
		
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg","Removido com Sucesso");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/anime/listar");
		
	}
	
	
		@GetMapping("index")
		public String index(){
			
			return ("anime/index");
		}
		
	}
	

