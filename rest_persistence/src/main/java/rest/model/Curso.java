package rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="curso")
@XmlAccessorType(XmlAccessType.FIELD)
public class Curso {
	
	private int id;
	private String curso;
	
	public Curso(int id, String curso) {
		super();
		this.id = id;
		this.curso = curso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", curso=" + curso + "]";
	}
	

}
