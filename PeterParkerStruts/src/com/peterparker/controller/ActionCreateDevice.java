package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Dispositivo;

public class ActionCreateDevice {
	private Dispositivo dispositivo;
	private List<Dispositivo> dispositivos;

	public List<Dispositivo> getDispositivos() {
		return this.dispositivos;
	}

	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String execute() throws Exception {
		DeviceDAO dao = new DeviceDAO();
		dao.add(this.dispositivo);
		this.dispositivos = dao.get();
		return "success";
	}

}
