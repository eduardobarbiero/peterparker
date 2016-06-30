package org.catolicasc.peterparker.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {

	@Id
	@GeneratedValue
	private Long id;
	private String localizacao;
	private String descricao;

	public Device(Long id) {
		this.id = id;
	}

	public Device(Long id, String localizacao, String descricao) {
		this.id = id;
		this.localizacao = localizacao;
		this.descricao = descricao;
	}

	public Device() {
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

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
