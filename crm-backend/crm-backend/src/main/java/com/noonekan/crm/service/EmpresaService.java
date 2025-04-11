package com.noonekan.crm.service;

import com.noonekan.crm.entity.AnexoDocumento;
import com.noonekan.crm.entity.CategoriaPersonalizada;
import com.noonekan.crm.entity.Empresa;
import com.noonekan.crm.entity.Fornecedor;
import com.noonekan.crm.entity.Funcionario;
import com.noonekan.crm.entity.Usuario;


public class EmpresaService {

    public void adicionarUsuario(Empresa empresa, Usuario usuario) {
        if (empresa != null && usuario != null) {
            empresa.getUsuarios().add(usuario);
            usuario.setEmpresa(empresa);
        }
    }

    public void removerUsuario(Empresa empresa, Usuario usuario) {
        if (empresa != null && usuario != null) {
        	empresa.getUsuarios().remove(usuario);
            usuario.setEmpresa(null);
        }
    }

    public void adicionarFuncionario(Empresa empresa, Funcionario funcionario) {
        if (empresa != null && funcionario != null) {
            empresa.getFuncionarios().add(funcionario);
            funcionario.setEmpresa(empresa);
        }
    }

    public void removerFuncionario(Empresa empresa, Funcionario funcionario) {
        if (empresa != null && funcionario != null) {
            empresa.getFuncionarios().remove(funcionario);
            funcionario.setEmpresa(null);
        }
    }

    public void adicionarFornecedor(Empresa empresa, Fornecedor fornecedor) {
        if (empresa != null && fornecedor != null) {
            empresa.getFornecedores().add(fornecedor);
            fornecedor.setEmpresa(empresa);
        }
    }

    public void removerFornecedor(Empresa empresa, Fornecedor fornecedor) {
        if (empresa != null && fornecedor != null) {
            empresa.getFornecedores().remove(fornecedor);
            fornecedor.setEmpresa(null);
        }
    }

    public void adicionarAnexo(Empresa empresa, AnexoDocumento anexo) {
        if (empresa != null && anexo != null) {
            empresa.getAnexos().add(anexo);
            anexo.setEmpresa(empresa);
        }
    }

    public void removerAnexo(Empresa empresa, AnexoDocumento anexo) {
        if (empresa != null && anexo != null) {
            empresa.getAnexos().remove(anexo);
            anexo.setEmpresa(null);
        }
    }

    public void adicionarCategoria(Empresa empresa, CategoriaPersonalizada categoria) {
        if (empresa != null && categoria != null) {
            empresa.getCategorias().add(categoria);
            categoria.setEmpresa(empresa);
        }
    }

    public void removerCategoria(Empresa empresa, CategoriaPersonalizada categoria) {
        if (empresa != null && categoria != null) {
            empresa.getCategorias().remove(categoria);
            categoria.setEmpresa(null);
        }
    }
}
