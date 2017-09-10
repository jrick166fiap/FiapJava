package br.com.fiap.entity.anime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAnime",sequenceName="SQ_ANIME",allocationSize =1)
public class Anime {
	
	@Id
	@GeneratedValue(generator="seqAnime",strategy=GenerationType.SEQUENCE)
	private int codigo;
	private String nome;
	private String personagemPrincipal;
	private int episodios;
	private String trilhasonora;
	
	
	public Anime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPersonagemPrincipal() {
		return personagemPrincipal;
	}
	public void setPersonagemPrincipal(String personagemPrincipal) {
		this.personagemPrincipal = personagemPrincipal;
	}
	public int getEpisodios() {
		return episodios;
	}
	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}
	public String getTrilhasonora() {
		return trilhasonora;
	}
	public void setTrilhasonora(String trilhasonora) {
		this.trilhasonora = trilhasonora;
	}

	
}
