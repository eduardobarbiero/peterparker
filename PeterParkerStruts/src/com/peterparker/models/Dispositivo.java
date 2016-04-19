package com.peterparker.models;

public class Dispositivo {

	private Long id;
	private String localizacao;
	private String descricao;

	public Dispositivo(Long id, String address, String description) {
		this.id = id;
		this.localizacao = address;
		this.descricao = description;
	}

	public Dispositivo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String address) {
		this.localizacao = address;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
