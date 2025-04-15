package com.noonekan.crm.service.ejb;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.noonekan.crm.dto.FuncionarioDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.entity.Funcionario;
import com.noonekan.crm.service.FuncionarioService;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FuncionarioServiceEJB implements FuncionarioService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setDepartamento(dto.getDepartamento());
        funcionario.setTipoContrato(dto.getTipoContrato());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setDataDemissao(dto.getDataDemissao());
        funcionario.setAtivo(dto.isAtivo());
        
        Empresa empresa = em.find(Empresa.class, dto.getEmpresaId());
        funcionario.setEmpresa(empresa);
        
        em.persist(funcionario);
    }

    
    public FuncionarioDTO obterFuncionario(Long id) {
        Funcionario funcionario = em.find(Funcionario.class, id);
        return funcionario != null ? toDTO(funcionario) : null;
    }

    
    public void atualizarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = em.find(Funcionario.class, dto.getId());
        if (funcionario != null) {
            funcionario.setNome(dto.getNome());
            funcionario.setCpf(dto.getCpf());
            funcionario.setEmail(dto.getEmail());
            funcionario.setTelefone(dto.getTelefone());
            funcionario.setEndereco(dto.getEndereco());
            funcionario.setDepartamento(dto.getDepartamento());
            funcionario.setTipoContrato(dto.getTipoContrato());
            funcionario.setDataNascimento(dto.getDataNascimento());
            funcionario.setCargo(dto.getCargo());
            funcionario.setSalario(dto.getSalario());
            funcionario.setDataAdmissao(dto.getDataAdmissao());
            funcionario.setDataDemissao(dto.getDataDemissao());
            funcionario.setAtivo(dto.isAtivo());
            
            Empresa empresa = em.find(Empresa.class, dto.getEmpresaId());
            funcionario.setEmpresa(empresa);
            
            em.merge(funcionario);
        }
    }

    
    public void removerFuncionario(Long id) {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
    }

    
    public List<FuncionarioDTO> listarPorEmpresa(Long empresaId) {
        Empresa empresa = em.find(Empresa.class, empresaId);
        if (empresa != null) {
            return empresa.getFuncionarios().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    
    public List<FuncionarioDTO> listarAtivosPorEmpresa(Long empresaId) {
        Empresa empresa = em.find(Empresa.class, empresaId);
        if (empresa != null) {
            return empresa.getFuncionarios().stream()
                .filter(Funcionario::isAtivo)
                .map(this::toDTO)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setEmail(funcionario.getEmail());
        dto.setTelefone(funcionario.getTelefone());
        dto.setEndereco(funcionario.getEndereco());
        dto.setDepartamento(funcionario.getDepartamento());
        dto.setTipoContrato(funcionario.getTipoContrato());
        dto.setDataNascimento(funcionario.getDataNascimento());
        dto.setCargo(funcionario.getCargo());
        dto.setSalario(funcionario.getSalario());
        dto.setDataAdmissao(funcionario.getDataAdmissao());
        dto.setDataDemissao(funcionario.getDataDemissao());
        dto.setAtivo(funcionario.isAtivo());
    
        dto.setEmpresaId(funcionario.getEmpresa().getId());
        return dto;
    }
}