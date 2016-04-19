package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Dispositivo;

public class ActionListaDevice {
	private List<Dispositivo> dispositivos;

	public List<Dispositivo> getDispositivos() {
		return this.dispositivos;
	}

	public String execute() throws Exception {

		DeviceDAO dao = new DeviceDAO();
		this.dispositivos = dao.get();

		return "success";
	}

}
