package com.peterparker.business_rule.car;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class ListCar implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarDAO dao = new CarDAO();
		List<Car> cars = dao.get();
		request.setAttribute("cars", cars); 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Car/list-cars.jsp");
		rd.forward(request, response);
		return "Car/car-list.jsp";
	}
}
