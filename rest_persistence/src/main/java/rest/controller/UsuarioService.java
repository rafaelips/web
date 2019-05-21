package rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.multipart.FormDataParam;

import rest.dao.UsuarioDao;
import rest.model.Usuario;

@Path("/usuarios")
public class UsuarioService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Usuario> getUsuarios(){
		return  UsuarioDao.getUsuarios();		
	}
	
	@GET
	@Path("/{matricula}")
	public Response getUSuario(@PathParam("matricula")String matricula) {
		return Response.status(Status.OK).entity(UsuarioDao.getUsuario(matricula)).build();
	}	
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Usuario adicionar(@FormDataParam("nome") String nome,@FormDataParam("sobrenome") String sobrenome,@FormDataParam("matricula") String matricula,
			@FormDataParam("senha") String senha) {		
		return UsuarioDao.cadastrar(nome, sobrenome, senha, matricula);
	}	
}
