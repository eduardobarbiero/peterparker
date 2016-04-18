package com.peterparker.controller;

import java.util.Calendar;
import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;
import com.peterparker.models.Ticket;

public class ActionCreateTicket {
	private Ticket ticket;
	private List<Car> cars;
	private List<Device> devices;
	private List<Ticket> tickets;

	public List<Car> getCars() {
		return this.cars;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setCar(Car car) {
		this.ticket.setCar(new CarDAO().getIdById(car.getId().toString()));
	}

	public void setDispositivoEntrada(Device device) {
		this.ticket.setDispositivoEntrada(new DeviceDAO().getDeviceById(device.getId().toString()));
	}

	public String execute() throws Exception {
		CarDAO dao = new CarDAO();
		this.cars = dao.get();

		DeviceDAO dao1 = new DeviceDAO();
		this.devices = dao1.get();

		TicketDAO tick_dao = new TicketDAO();
		this.ticket.setHoraEntrada(Calendar.getInstance());
		tick_dao.add(this.ticket);

		this.tickets = tick_dao.getList();

		return "success";
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
