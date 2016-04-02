package org.catolicasc.peterparker.modelo;

import java.util.Calendar;

public class Ticket {

	private Long id;
	private Car car;
	private Device dispositivoEntrada;
	private Device dispositivoSaida;
	private Calendar horaEntrada;
	private Calendar horaSaida;

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Device getDispositivoEntrada() {
		return this.dispositivoEntrada;
	}

	public void setDispositivoEntrada(Device dispositivoEntrada) {
		this.dispositivoEntrada = dispositivoEntrada;
	}

	public Device getDispositivoSaida() {
		return this.dispositivoSaida;
	}

	public void setDispositivoSaida(Device dispositivoSaida) {
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
