package com.noonekan.crm.service.ejb;

import com.noonekan.crm.dto.EmpresaDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.entity.Usuario;
import com.noonekan.crm.service.EmpresaService;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class EmpresaServiceEJB implements EmpresaService {

	@PersistenceContext
	private EntityManager em;

	public void cadastrarEmpresa(EmpresaDTO dto) {
		Empresa empresa = new Empresa();

		empresa.setId(dto.getId());
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

	}

	public EmpresaDTO obterEmpresa(Long id) {
		Empresa empresa = em.find(Empresa.class, id);

		if (empresa != null){
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
		
		return null;

	}

	public void atualizarEmpresa(EmpresaDTO dto) {

		Empresa empresa = em.find(Empresa.class, dto.getId());

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
	}

	public void removerEmpresa(Long id) {
		Empresa empresa = em.find(Empresa.class, id);
		if (empresa != null) {
			em.remove(empresa);
		}
	}

	public boolean usuarioPossuiEmpresa(Long usuarioId) {
	    Usuario usuario = em.find(Usuario.class, usuarioId);
	    return usuario != null && usuario.getEmpresa() != null;
	}




}