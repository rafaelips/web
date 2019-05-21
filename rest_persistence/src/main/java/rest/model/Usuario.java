package rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String senha;
	private String matricula;// modificar para matricula	
	//private int tipo_usuario;
	
	public Usuario() {
		
	}
	public Usuario(int id, String nome, String sobrenome, String senha, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.matricula = matricula;		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
