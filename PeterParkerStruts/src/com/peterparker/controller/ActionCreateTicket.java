package com.peterparker.controller;

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
	private Car car;
	private Device device;

	public List<Car> getCars() {
		return cars;
	}
	
	public List<Device> getDevices() {
		return devices;
	}	
	
	public void setCar(Car car){
		this.ticket.setCar(new CarDAO().getIdById(car.getId().toString()));
	}
	
	public void setDispositivoEntrada(Device device){
		this.ticket.setDispositivoEntrada(new DeviceDAO().getDeviceById(device.getId().toString()));		
	}
	
	public String execute() throws Exception {
		//
		CarDAO dao = new CarDAO();			

		cars = dao.get();

		DeviceDAO dao1 = new DeviceDAO();			

		devices = dao1.get();
		
		//
		TicketDAO tick_dao = new TicketDAO();
		tick_dao.add(ticket);				

		return "success";
	}

}
