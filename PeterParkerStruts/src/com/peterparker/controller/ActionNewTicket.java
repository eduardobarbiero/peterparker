package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;
import com.peterparker.models.Ticket;

public class ActionNewTicket {	
	private Ticket ticket;
	private List<Car> cars;
	private List<Device> devices;

	public List<Car> getCars() {
		return cars;
	}
	
	public List<Device> getDevices() {
		return devices;
	}	

	public String execute() throws Exception {
		CarDAO dao = new CarDAO();			

		cars = dao.get();

		DeviceDAO dao1 = new DeviceDAO();			

		devices = dao1.get();

		return "success";
	}

}
