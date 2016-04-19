package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Dispositivo;
import com.peterparker.models.Ticket;

public class ActionListaTicket {
	private List<Ticket> tickets;
	private List<Ticket> ticketsSaida;
	private List<Dispositivo> dispositivos;

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public List<Ticket> getTicketsSaida() {
		return this.ticketsSaida;
	}

	public List<Dispositivo> getDevices() {
		return this.dispositivos;
	}

	public String execute() throws Exception {
		TicketDAO dao = new TicketDAO();
		this.tickets = dao.getList();

		TicketDAO dao1 = new TicketDAO();
		this.ticketsSaida = dao1.getListLeft();

		DeviceDAO dao_device = new DeviceDAO();
		this.dispositivos = dao_device.get();

		return "success";
	}

}
