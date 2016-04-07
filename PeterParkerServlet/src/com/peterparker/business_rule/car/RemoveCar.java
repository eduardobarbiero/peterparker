package com.peterparker.business_rule.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.models.Car;

public class RemoveCar implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Car car = new Car();
		CarDAO dao = new CarDAO();
		car.setId(Long.parseLong(request.getParameter("id")));
		dao.remove(car);
		System.out.println("Removendo Carro... ");
		return "index.jsp";
	}

}
