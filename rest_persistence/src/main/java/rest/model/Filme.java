package rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filme")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filme {

	
	private int idfilme;
	private String nome_filme1;
	private String nome_filme2;
	private String nome_filme3;
	private int status;
	private int voto_filme1;
	private int voto_filme2;
	private int voto_filme3;
	
	public Filme() {
		
	}
	
	public Filme(int idfilme, String nome_filme1, String nome_filme2, String nome_filme3, int status, int voto_filme1,
			int voto_filme2, int voto_filme3) {
		super();
		this.idfilme = idfilme;
		this.nome_filme1 = nome_filme1;
		this.nome_filme2 = nome_filme2;
		this.nome_filme3 = nome_filme3;
		this.status = status;
		this.voto_filme1 = voto_filme1;
		this.voto_filme2 = voto_filme2;
		this.voto_filme3 = voto_filme3;
	}
	public Filme(int idfilmes, String nome_filme1, String nome_filme2, String nome_filme3, int status) {
		this.idfilme = idfilmes;
		this.nome_filme1 = nome_filme1;
		this.nome_filme2 = nome_filme2;
		this.nome_filme3 = nome_filme3;
		this.status = status;
		this.voto_filme1 =0;
		this.voto_filme2 =0;
		this.voto_filme3 =0;
	}
	public int getIdfilme() {
		return idfilme;
	}
	public void setIdfilme(int idfilmes) {
		this.idfilme = idfilmes;
	}
	public String getNome_filme1() {
		return nome_filme1;
	}
	public void setNome_filme1(String nome_filme1) {
		this.nome_filme1 = nome_filme1;
	}
	public String getNome_filme2() {
		return nome_filme2;
	}
	public void setNome_filme2(String nome_filme2) {
		this.nome_filme2 = nome_filme2;
	}
	public String getNome_filme3() {
		return nome_filme3;
	}
	public void setNome_filme3(String nome_filme3) {
		this.nome_filme3 = nome_filme3;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getVoto_filme1() {
		return voto_filme1;
	}
	public void setVoto_filme1(int voto_filme1) {
		this.voto_filme1 = voto_filme1;
	}
	public int getVoto_filme2() {
		return voto_filme2;
	}
	public void setVoto_filme2(int voto_filme2) {
		this.voto_filme2 = voto_filme2;
	}
	public int getVoto_filme3() {
		return voto_filme3;
	}
	public void setVoto_filme3(int voto_filme3) {
		this.voto_filme3 = voto_filme3;
	}
	
	
}
