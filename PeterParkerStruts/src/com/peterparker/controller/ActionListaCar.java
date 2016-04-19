package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.models.Carro;

public class ActionListaCar {
	private List<Carro> cars;

	public List<Carro> getCars() {
		return this.cars;
	}

	public String execute() throws Exception {

		CarDAO dao = new CarDAO();
		this.cars = dao.get();

		return "success";
	}

}
