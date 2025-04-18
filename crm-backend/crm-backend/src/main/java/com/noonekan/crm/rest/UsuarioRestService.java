package com.noonekan.crm.rest;


import com.noonekan.crm.delegate.UsuarioDelegate;
import com.noonekan.crm.dto.UsuarioDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestService {

	@Inject
	private UsuarioDelegate usuarioDelegate;

	@POST
	@Path("salvar-usario/{id}")
	public Response criar(UsuarioDTO usuarioDTO) throws Exception {
		usuarioDelegate.cadastrarUsuario(usuarioDTO);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("buscar-usuario/{id}")
	public UsuarioDTO buscarPorId(@PathParam("id") Long id) throws Exception {
		return usuarioDelegate.obterUsuario(id);
	}

	@PUT
	@Path("atualizar-usuario/{id}")
	public Response atualizar(@PathParam("id") Long id, UsuarioDTO usuarioDTO) throws Exception {
		usuarioDTO.setId(id);
		usuarioDelegate.atualizarUsuario(usuarioDTO);
		return Response.ok().build();
	}

	@DELETE
	@Path("remover-usuario/{id}")
	public Response remover(@PathParam("id") Long id) throws Exception {
		usuarioDelegate.removerUsuario(id);
		return Response.noContent().build();
	}

	@GET
	@Path("/existe/{id}")
	public boolean verificarExistencia(@PathParam("id") Long id) throws Exception {
		return usuarioDelegate.possuiUsuario(id);
	}

}