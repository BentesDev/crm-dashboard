package com.noonekan.crm.service.ejb;

import com.noonekan.crm.dto.UsuarioDTO;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.entity.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UsuarioFachada {

    @PersistenceContext(unitName = "crmPU")
    private EntityManager em;

    public UsuarioDTO salvar(UsuarioDTO dto) {
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

        return toDTO(usuario);
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        return usuario != null ? toDTO(usuario) : null;
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        dto.setEmpresaId(usuario.getEmpresa() != null ? usuario.getEmpresa().getId() : null);
        return dto;
    }
}
