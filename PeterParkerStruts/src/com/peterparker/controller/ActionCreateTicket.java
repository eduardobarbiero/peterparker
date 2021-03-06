package com.peterparker.controller;

import java.util.Calendar;
import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Carro;
import com.peterparker.models.Dispositivo;
import com.peterparker.models.Ticket;

public class ActionCreateTicket {
	private Ticket ticket;
	private List<Carro> cars;
	private List<Dispositivo> dispositivos;
	private List<Ticket> tickets;
	private List<Ticket> ticketsSaida;

	public List<Carro> getCars() {
		return this.cars;
	}

	public List<Ticket> getTicketsSaida() {
		return this.ticketsSaida;
	}

	public void setTicketsSaida(List<Ticket> ticketsSaida) {
		this.ticketsSaida = ticketsSaida;
	}

	public List<Dispositivo> getDevices() {
		return this.dispositivos;
	}

	public Ticket getTicket() {
		return this.ticket;
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
		CarDAO dao = new CarDAO();
		this.cars = dao.get();

		DeviceDAO dao1 = new DeviceDAO();
		this.dispositivos = dao1.get();

		TicketDAO tick_dao = new TicketDAO();
		this.ticket.setHoraEntrada(Calendar.getInstance());
		tick_dao.add(this.ticket);

		this.tickets = tick_dao.getList();

		TicketDAO dao2 = new TicketDAO();
		this.ticketsSaida = dao2.getListLeft();

		return "success";
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
