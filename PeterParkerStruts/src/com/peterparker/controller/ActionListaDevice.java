package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Device;

public class ActionListaDevice {
	private List<Device> devices;
	
	public List<Device> getDevices() {
		return devices;
	}
	
	public String execute() throws Exception {
		
		DeviceDAO dao = new DeviceDAO();
		devices = dao.get();
		
		return "success";
	}
	
}
