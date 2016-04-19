package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Carro;
import com.peterparker.models.Dispositivo;

public class ActionNewTicket {
	private List<Carro> cars;
	private List<Dispositivo> dispositivos;

	public List<Carro> getCars() {
		return this.cars;
	}

	public List<Dispositivo> getDevices() {
		return this.dispositivos;
	}

	public String execute() throws Exception {
		CarDAO dao = new CarDAO();
		this.cars = dao.get();

		DeviceDAO dao1 = new DeviceDAO();
		this.dispositivos = dao1.get();

		return "success";
	}

}
