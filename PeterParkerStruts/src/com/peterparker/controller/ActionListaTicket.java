package com.peterparker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Device;
import com.peterparker.models.Ticket;

public class ActionListaTicket {
	private List<Ticket> tickets;
	private List<Ticket> ticketsSaida;
	private List<Device> devices;

	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public List<Ticket> getTicketsSaida() {
		return ticketsSaida;
	}
	
	public List<Device> getDevices() {
		return devices;
	}

	public String execute() throws Exception {
		TicketDAO dao = new TicketDAO();
		tickets = dao.getList();

		TicketDAO dao1 = new TicketDAO();
		ticketsSaida = dao1.getListLeft();

		DeviceDAO dao_device = new DeviceDAO();
		devices = dao_device.get();

		return "success";
	}

}
