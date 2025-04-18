package com.noonekan.crm.delegate;

import java.util.List;

import com.noonekan.crm.dto.FuncionarioDTO;
import com.noonekan.crm.service.FuncionarioService;

import jakarta.inject.Inject;

public class FuncionarioDelegate {
	
 @Inject
 private FuncionarioService funcionarioService;
 
 
 
 public void cadastrarFuncionario(FuncionarioDTO dto) throws Exception{
	 funcionarioService.cadastrarFuncionario(dto);
 }
 
 public FuncionarioDTO obterFuncionario(Long id) throws Exception{
	 return funcionarioService.obterFuncionario(id);
 }
 
 public void atualizarFuncionario(FuncionarioDTO dto) throws Exception{
	 funcionarioService.atualizarFuncionario(dto);
 }
 
 public void removerFuncionario(Long id) throws Exception{
	  funcionarioService.removerFuncionario(id);
 }
 
 public List<FuncionarioDTO> listarPorEmpresa(Long empresaId) throws Exception{
	 return funcionarioService.listarPorEmpresa(empresaId);
 }
 
 public List<FuncionarioDTO> listarAtivosPorEmpresa(Long empresaId) throws Exception{
	 return funcionarioService.listarAtivosPorEmpresa(empresaId);
 }
 
}