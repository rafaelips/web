package rest.controller;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.multipart.FormDataParam;

import rest.dao.FilmeDao;
import rest.model.Filme;

@Path("/filme")
public class FilmeService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Filme> getFilmes(){	
		return FilmeDao.getFilmes();	
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response cadastrar(@FormDataParam("primeiroNome") String primeiroNome,
			@FormDataParam("segundoNome") String segundoNome,
			@FormDataParam("terceiroNome") String terceiroNome,
			@FormDataParam("arquivo1") InputStream arquivo1,
			@FormDataParam("arquivo2") InputStream arquivo2,
			@FormDataParam("arquivo3") InputStream arquivo3
			) {
			return Response.status(Status.OK).entity(FilmeDao.cadastrar(primeiroNome, segundoNome, terceiroNome, arquivo1, arquivo2, arquivo3)).build();		
	}
	
}
