package com.noonekan.crm.service.facade;


import com.noonekan.crm.dto.EmpresaDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.service.EmpresaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class EmpresaFachada implements EmpresaService {

    @PersistenceContext
    protected EntityManager em;

    	
    public EmpresaDTO cadastrarEmpresa(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setRazaoSocial(dto.getRazaoSocial());
        empresa.setCnpj(dto.getCnpj());
        empresa.setDataCadastro(dto.getDataCadastro());
        empresa.setEndereco(dto.getEndereco());
        empresa.setNumero(dto.getNumero());
        empresa.setComplemento(dto.getComplemento());
        empresa.setBairro(dto.getBairro());
        empresa.setCidade(dto.getCidade());
        empresa.setEstado(dto.getEstado());
        empresa.setCep(dto.getCep());
        
        em.persist(empresa);
        
        return toDTO(empresa);
    }

    public EmpresaDTO obterEmpresa(Long id) {
        Empresa empresa = em.find(Empresa.class, id);
        return empresa != null ? toDTO(empresa) : null;
    }

   
    public EmpresaDTO atualizarEmpresa(EmpresaDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("ID da empresa é obrigatório para atualização");
        }
        
        Empresa empresa = em.find(Empresa.class, dto.getId());
        if (empresa == null) {
            throw new IllegalArgumentException("Empresa não encontrada com ID: " + dto.getId());
        }
        
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setRazaoSocial(dto.getRazaoSocial());
        empresa.setCnpj(dto.getCnpj());
        empresa.setDataCadastro(dto.getDataCadastro());
        empresa.setEndereco(dto.getEndereco());
        empresa.setNumero(dto.getNumero());
        empresa.setComplemento(dto.getComplemento());
        empresa.setBairro(dto.getBairro());
        empresa.setCidade(dto.getCidade());
        empresa.setEstado(dto.getEstado());
        empresa.setCep(dto.getCep());
        
        em.merge(empresa);
        return toDTO(empresa);
    }

    public void removerEmpresa(Long id) {
        Empresa empresa = em.find(Empresa.class, id);
        if (empresa != null) {
            em.remove(empresa);
        }
    }

    protected EmpresaDTO toDTO(Empresa empresa) {
        EmpresaDTO dto = new EmpresaDTO();
        
        dto.setId(empresa.getId());
        dto.setNomeFantasia(empresa.getNomeFantasia());
        dto.setRazaoSocial(empresa.getRazaoSocial());
        dto.setCnpj(empresa.getCnpj());
        dto.setDataCadastro(empresa.getDataCadastro());
        dto.setEndereco(empresa.getEndereco());
        dto.setNumero(empresa.getNumero());
        dto.setComplemento(empresa.getComplemento());
        dto.setBairro(empresa.getBairro());
        dto.setCidade(empresa.getCidade());
        dto.setEstado(empresa.getEstado());
        dto.setCep(empresa.getCep());
        
        
        return dto;
    }
    
    public boolean usuarioPossuiEmpresa(Long usuarioId) {
        TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(e) FROM Empresa e JOIN e.usuarios u WHERE u.id = :usuarioId", 
            Long.class
        );
        query.setParameter("usuarioId", usuarioId);
        return query.getSingleResult() > 0;
    }


    protected void toEntity(EmpresaDTO dto, Empresa empresa) {
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setRazaoSocial(dto.getRazaoSocial());
        empresa.setCnpj(dto.getCnpj());
        empresa.setDataCadastro(dto.getDataCadastro());
        empresa.setEndereco(dto.getEndereco());
        empresa.setNumero(dto.getNumero());
        empresa.setComplemento(dto.getComplemento());
        empresa.setBairro(dto.getBairro());
        empresa.setCidade(dto.getCidade());
        empresa.setEstado(dto.getEstado());
        empresa.setCep(dto.getCep());
    }


}