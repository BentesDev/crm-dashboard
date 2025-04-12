package com.noonekan.crm.service;

import com.noonekan.crm.dto.EmpresaDTO;

public interface EmpresaService {
    EmpresaDTO cadastrarEmpresa(EmpresaDTO dto);
    EmpresaDTO obterEmpresa(Long id);
    EmpresaDTO atualizarEmpresa(EmpresaDTO dto);
    void removerEmpresa(Long id);
    boolean usuarioPossuiEmpresa(Long idUsuario);
}