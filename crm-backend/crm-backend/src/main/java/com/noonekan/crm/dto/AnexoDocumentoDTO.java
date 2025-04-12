package com.noonekan.crm.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AnexoDocumentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeArquivo;
	private String tipo;
	private String caminho;
	private LocalDateTime dataUpload;
	private Long empresaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public LocalDateTime getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(LocalDateTime dataUpload) {
		this.dataUpload = dataUpload;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
}
