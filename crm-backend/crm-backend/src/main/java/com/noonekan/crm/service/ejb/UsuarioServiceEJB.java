package com.noonekan.crm.service.ejb;

import com.noonekan.crm.dto.UsuarioDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.entity.Usuario;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UsuarioServiceEJB {

    @PersistenceContext(unitName = "crmPU")
    private EntityManager em;

    public void salvarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        if (dto.getEmpresaId() != null) {
            Empresa empresa = em.find(Empresa.class, dto.getEmpresaId());
            usuario.setEmpresa(empresa);
        }

        em.persist(usuario);
        em.flush();

    }

    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if(usuario != null) {
        	UsuarioDTO dto = new UsuarioDTO();
        	//TO-DO
        	dto.setId(usuario.getId());
        	return dto;
        }
        
        return null;
    }
    
    public void editar(Long id, UsuarioDTO dto) {
        Usuario usuario = em.find(Usuario.class, id);
    

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        if (dto.getEmpresaId() != null) {
            Empresa empresa = em.find(Empresa.class, dto.getEmpresaId());
            usuario.setEmpresa(empresa);
        }

        em.merge(usuario);
    }



}
