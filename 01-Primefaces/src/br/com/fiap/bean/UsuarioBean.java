package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	
	private UsuarioBO bo;
	
	private StreamedContent foto;

	
	//Método que realiza o upload de arquivo
	public void subirFoto(FileUploadEvent event){
		
		try {
			usuario.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Cadastrar a foto no banco
		//Criar um arquivo com o nome do arquivo de upload
		try {
		File file = new File("C:\\foto\\",event.getFile().getFileName());
		//Gravar informação no arquivo
			FileOutputStream output = new FileOutputStream(file);
			output.write(event.getFile().getContents());
			output.close();
			//Grava o nome do arquivo no banco
			usuario.setFoto(event.getFile().getFileName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public StreamedContent getFoto() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 DefaultStreamedContent content = new DefaultStreamedContent();
		 content.setContentType("image/jpg");
		 try {
		 if (context.getRenderResponse() || usuario.getFoto() == null) {
			 content.setStream(new FileInputStream("C:\\foto\\semFoto.jpg"));
		 	} else {
		 		content.setStream(new ByteArrayInputStream(usuario.getFoto()));
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return content;
		}
	
	
	
	@PostConstruct
	private void init(){
		//Inicializar os objetos
		usuario = new Usuario();
		usuario.setDataNascimento(Calendar.getInstance());
		bo = new UsuarioBO();
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if(usuario.getCodigo() ==0){
			bo.cadastrar(usuario);
			msg = new FacesMessage("Cadastrado!");
			usuario = new Usuario();
			usuario.setDataNascimento(Calendar.getInstance());
		
			}else{
				bo.atualizar(usuario);
				msg = new FacesMessage("Atualizado!");
				
			}
			usuario = new Usuario();
			usuario.setDataNascimento(Calendar.getInstance());
			
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
		return "usuario?faces-redirect=true";
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
