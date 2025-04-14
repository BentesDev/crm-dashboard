package com.noonekan.crm.service;

import com.noonekan.crm.dto.FuncionarioDTO;
import java.util.List;

public interface FuncionarioService {

	public void cadastrarFuncionario(FuncionarioDTO dto) throws Exception;

	public FuncionarioDTO obterFuncionario(Long id) throws Exception;

	public void atualizarFuncionario(FuncionarioDTO dto) throws Exception;

	public void removerFuncionario(Long id) throws Exception;

	public List<FuncionarioDTO> listarPorEmpresa(Long empresaId) throws Exception;

	public List<FuncionarioDTO> listarAtivosPorEmpresa(Long empresaId) throws Exception;

}