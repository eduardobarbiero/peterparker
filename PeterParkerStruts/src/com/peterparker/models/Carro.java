package com.peterparker.models;

public class Carro {

	private Long id;

	private String placa;

	private String cor;

	public Carro(Long id, String board, String color) {
		this.id = id;
		this.placa = board;
		this.cor = color;
	}

	public Carro() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
