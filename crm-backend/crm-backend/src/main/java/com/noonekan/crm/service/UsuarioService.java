package com.noonekan.crm.service;

import com.noonekan.crm.dto.UsuarioDTO;

public interface UsuarioService {
	
	public void cadastrarUsuario(UsuarioDTO dto) throws Exception;
	
	public UsuarioDTO obterUsuario(Long id) throws Exception;
	
	public void removerUsuario(Long id) throws Exception;
	
	public void atualizarUsuario(UsuarioDTO dto) throws Exception;
	
	public boolean possuiUsuario(Long id) throws Exception;

}
