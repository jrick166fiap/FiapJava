package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	//Simular o banco de dados
	
	//private static List<Veiculo> banco = new ArrayList<>();
	
	//Banco Real
	
	@Autowired // Servidor vai injetar um objeto aqui.
	private VeiculoDAO dao;

	@GetMapping("cadastrar") // abre a tela de formul�rio
	public ModelAndView abrirForm() {

		return new ModelAndView("veiculo/cadastro").addObject("veiculo",new Veiculo());

	}
    
	@PostMapping("cadastrar") // Processa as informa��es do formul�rio
	@Transactional
	public ModelAndView processaForm(@Valid Veiculo veiculo, BindingResult result,RedirectAttributes redirect) {

		ModelAndView retorno;
		//Validar se existe erro de valida��o.
		if(result.hasErrors()){
			retorno = new ModelAndView("veiculo/cadastro");
			
		}else{
		
		//Cadastrar no banco
		dao.cadastrar(veiculo);
		//Retorno... redirecionar para o m�todo listar
		retorno = new ModelAndView("redirect:/veiculo/listar");
		redirect.addFlashAttribute("msg", "Cadastrado com sucesso!");
		}
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listarForm(){
		
		ModelAndView retorno = new ModelAndView("veiculo/lista");
		//retorno.addObject("listao",banco);
		retorno.addObject("listao",dao.listar());
		return retorno;
		
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarForm(@PathVariable("id") int id){
		
		Veiculo veiculo = dao.pesquisar(id);
		ModelAndView retorno = new ModelAndView("veiculo/editar");
		
		retorno.addObject("veiculo",veiculo);
		
		return retorno;	
	}
	
	@PostMapping("editar")
	@Transactional
	public ModelAndView processaEditar(@Valid Veiculo veiculo,BindingResult result,RedirectAttributes redirect){
		ModelAndView retorno;
		
		if(result.hasErrors()){
			retorno = new ModelAndView ("veiculo/editar");
			
		}else{
		//veiculo.setCodigo(id);
		dao.alterar(veiculo);
		
		redirect.addFlashAttribute("msg","Alterado com Sucesso");
		retorno = new ModelAndView("redirect:/veiculo/listar");
		}
		return retorno;		
	}
	
	@PostMapping("remover")
	@Transactional
	public ModelAndView excluir(int codigo ,RedirectAttributes redirect){
		
		try {
			dao.remover(codigo);
			redirect.addFlashAttribute("msg", "Exclu�do com Sucesso");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirect.addFlashAttribute("msg", "Erro ao Remover");
		}
		
		
		
		return new ModelAndView("redirect:/veiculo/listar");
		
		
	}

}
