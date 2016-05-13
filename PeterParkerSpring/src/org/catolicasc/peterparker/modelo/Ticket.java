package org.catolicasc.peterparker.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Car carro;

	@OneToOne
	private Device dispositivoEntrada;

	@OneToOne
	private Device dispositivoSaida;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horaEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horaSaida;

	public Ticket(Long id, Car car, Device entrada, Device saida, Calendar horaEntrada, Calendar horaSaida) {
		this.id = id;
		this.carro = car;
		this.dispositivoEntrada = entrada;
		this.dispositivoSaida = saida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public Ticket() {
	}

	public Car getCarro() {
		return this.carro;
	}

	public void setCarro(Car car) {
		this.carro = car;
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
