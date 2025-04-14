package com.noonekan.crm.delegate;

import javax.inject.Inject;

import com.noonekan.crm.dto.UsuarioDTO;
import com.noonekan.crm.service.UsuarioService;

public class UsuarioDelegate {
	
	@Inject
	
	private UsuarioService usuarioService;
	
	public void cadastrarUsuario(UsuarioDTO dto) throws Exception{
		usuarioService.cadastrarUsuario(dto);
	}
	
	public UsuarioDTO obterUsuario(Long id) throws Exception{
		return usuarioService.obterUsuario(id);
	}
	
	public void removerUsuario(Long id) throws Exception{
		usuarioService.removerUsuario(id);
	}
	
	public void atualizarUsuario(UsuarioDTO dto) throws Exception{
		usuarioService.atualizarUsuario(dto);
	}
	
	public boolean possuiUsuario(Long id) throws Exception{
		return usuarioService.possuiUsuario(id);
	}
	



}
