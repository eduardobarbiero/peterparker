package com.peterparker.business_rule.car;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.models.Car;

public class AddCar implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Car car = new Car();
		CarDAO dao = new CarDAO();
		car.setBoard(request.getParameter("board"));
		car.setColor(request.getParameter("color"));
		dao.add(car);
		System.out.println("Cadastrando Carro... ");
		return "index.jsp";
	}

}
