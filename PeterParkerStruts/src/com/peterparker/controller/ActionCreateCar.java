package com.peterparker.controller;

import java.util.List;

import com.peterparker.dao.CarDAO;
import com.peterparker.models.Carro;

public class ActionCreateCar {
	private Carro carro;
	private List<Carro> cars;

	public List<Carro> getCars() {
		return this.cars;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String execute() throws Exception {
		CarDAO dao = new CarDAO();
		dao.add(this.carro);
		this.cars = dao.get();

		return "success";
	}

}
