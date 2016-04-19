package com.peterparker.controller;

import java.util.Calendar;
import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Carro;
import com.peterparker.models.Dispositivo;
import com.peterparker.models.Ticket;

public class ActionUpdateTicket {
	private Ticket ticket;
	private List<Carro> cars;
	private List<Ticket> tickets;
	private List<Ticket> ticketsSaida;
	private List<Dispositivo> dispositivos;

	public List<Carro> getCars() {
		return this.cars;
	}

	public List<Dispositivo> getDevices() {
		return this.dispositivos;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public List<Ticket> getTicketsSaida() {
		return this.ticketsSaida;
	}

	public void setTicketsSaida(List<Ticket> ticketsSaida) {
		this.ticketsSaida = ticketsSaida;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setCar(Carro car) {
		this.ticket.setCarro(new CarDAO().getIdById(car.getId().toString()));
	}

	public void setDispositivoEntrada(Dispositivo dispositivo) {
		this.ticket.setDispositivoEntrada(new DeviceDAO().getDeviceById(dispositivo.getId().toString()));
	}

	public String execute() throws Exception {
		TicketDAO tick_dao = new TicketDAO();
		this.ticket.setHoraSaida(Calendar.getInstance());
		tick_dao.update(this.ticket);

		TicketDAO dao = new TicketDAO();
		this.tickets = dao.getList();

		TicketDAO dao1 = new TicketDAO();
		this.ticketsSaida = dao1.getListLeft();

		return "success";
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
