package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class ActionListaCar {
	private List<Car> cars;
	
	public List<Car> getCars() {
		return cars;
	}
	
	public String execute() throws Exception {
		
		CarDAO dao = new CarDAO();
		cars = dao.get();
		
		return "success";
	}
	
}
