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

	@GetMapping("cadastrar") // abre a tela de formulário
	public ModelAndView abrirForm() {

		return new ModelAndView("veiculo/cadastro").addObject("veiculo",new Veiculo());

	}
    
	@PostMapping("cadastrar") // Processa as informações do formulário
	@Transactional
	public ModelAndView processaForm(Veiculo veiculo,RedirectAttributes redirect) {
		//Cadastrar no banco
		dao.cadastrar(veiculo);
		//Retorno... redirecionar para o método listar
		ModelAndView retorno = new ModelAndView("redirect:/veiculo/listar");
		redirect.addFlashAttribute("msg", "Cadastrado com sucesso!");
		
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
	public ModelAndView processaEditar(Veiculo veiculo,RedirectAttributes redirect){
		//veiculo.setCodigo(id);
		dao.alterar(veiculo);
		
		redirect.addFlashAttribute("msg","Alterado com Sucesso");
		return new ModelAndView("redirect:/veiculo/listar");
	}
	
	@GetMapping("/remover/{id}")
	@Transactional
	public ModelAndView excluir(@PathVariable("id") int id,RedirectAttributes redirect){
		
		try {
			dao.remover(id);
			redirect.addFlashAttribute("msg", "Excluído com Sucesso");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirect.addFlashAttribute("msg", "Erro ao Remover");
		}
		
		
		
		return new ModelAndView("redirect:/veiculo/listar");
		
		
	}

}
