package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class ActionCreateDevice {
	private Device device;
	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}	
	
	public Device getDevice() {
		return device;
	}
	
	public void setDevice(Device device) {
		this.device = device;
	}

	public String execute() throws Exception {
		DeviceDAO dao = new DeviceDAO();			
		dao.add(device);
		devices = dao.get();
		return "success";
	}

}
