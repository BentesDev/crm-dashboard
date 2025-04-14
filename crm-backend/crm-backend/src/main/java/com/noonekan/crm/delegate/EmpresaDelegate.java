package com.noonekan.crm.delegate;

import javax.inject.Inject;

import com.noonekan.crm.dto.EmpresaDTO;
import com.noonekan.crm.service.EmpresaService;

public class EmpresaDelegate {

    @Inject
    private EmpresaService empresaService;

    public void cadastrarEmpresa(EmpresaDTO dto) throws Exception {
        empresaService.cadastrarEmpresa(dto);
    }

    public EmpresaDTO obterEmpresa(Long id) throws Exception {
        return empresaService.obterEmpresa(id);
    }

    public void atualizarEmpresa(EmpresaDTO dto) throws Exception {
        empresaService.atualizarEmpresa(dto);
    }

    public void removerEmpresa(Long id) throws Exception {
        empresaService.removerEmpresa(id);
    }

    public boolean usuarioPossuiEmpresa(Long usuarioId) throws Exception {
        return empresaService.usuarioPossuiEmpresa(usuarioId);
    }
}