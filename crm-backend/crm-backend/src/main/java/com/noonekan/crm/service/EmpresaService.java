package com.noonekan.crm.service;

import com.noonekan.crm.dto.EmpresaDTO;

public interface EmpresaService {
    
	public void cadastrarEmpresa(EmpresaDTO dto) throws Exception;
    
    public EmpresaDTO obterEmpresa(Long id) throws Exception;
    
    public void atualizarEmpresa(EmpresaDTO dto) throws Exception;
    
    public void removerEmpresa(Long id) throws Exception;
    
    public boolean usuarioPossuiEmpresa(Long idUsuario) throws Exception;
}