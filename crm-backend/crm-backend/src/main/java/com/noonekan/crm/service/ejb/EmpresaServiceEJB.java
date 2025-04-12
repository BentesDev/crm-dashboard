package com.noonekan.crm.service.ejb;

import com.noonekan.crm.dto.EmpresaDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.service.EmpresaService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
		TypedQuery<Long> query = em
				.createQuery("SELECT COUNT(e) FROM Empresa e JOIN e.usuarios u WHERE u.id = :usuarioId", Long.class);
		query.setParameter("usuarioId", usuarioId);
		return query.getSingleResult() > 0;
	}



}