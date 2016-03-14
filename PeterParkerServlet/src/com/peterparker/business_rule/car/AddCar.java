package com.peterparker.business_rule.car;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.models.Car;

public class AddCar implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Car car = new Car();
		// car.setId(Long.parseLong((request.getParameter("id"))));
		// car.setBoard(request.getParameter("endereco"));
		// car.setTickets(request.getParameter("email"));
		// dao.adiciona(car);
		System.out.println("Cadastrando Carro... ");
		return "car-addeded.jsp";
	}

}
