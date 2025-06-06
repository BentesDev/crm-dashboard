package com.noonekan.crm.dto;

import java.io.Serializable;

public class CategoriaPersonalizadaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String tipo;
	private Long empresaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
}
