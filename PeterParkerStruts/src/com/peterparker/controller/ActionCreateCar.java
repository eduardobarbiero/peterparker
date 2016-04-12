package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class ActionCreateCar {	
	private Car car;
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}	
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}

	public String execute() throws Exception {
		CarDAO dao = new CarDAO();			
		dao.add(car);
		cars = dao.get();
		return "success";
	}

}
