package com.peterparker.models;

import java.util.Calendar;

public class Ticket {

	private Long id;
	private Carro carro;
	private Dispositivo dispositivoEntrada;
	private Dispositivo dispositivoSaida;
	private Calendar horaEntrada;
	private Calendar horaSaida;

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Dispositivo getDispositivoEntrada() {
		return this.dispositivoEntrada;
	}

	public void setDispositivoEntrada(Dispositivo dispositivoEntrada) {
		this.dispositivoEntrada = dispositivoEntrada;
	}

	public Dispositivo getDispositivoSaida() {
		return this.dispositivoSaida;
	}

	public void setDispositivoSaida(Dispositivo dispositivoSaida) {
		this.dispositivoSaida = dispositivoSaida;
	}

	public Calendar getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Calendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Calendar getHoraSaida() {
		return this.horaSaida;
	}

	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
