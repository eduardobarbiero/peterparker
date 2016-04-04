package com.peterparker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;
import com.peterparker.models.Ticket;

@SuppressWarnings("serial")
@WebServlet("/ticket/add")
public class AddTicketController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {			
		try {			
			CarDAO dao = new CarDAO();
			List<Car> cars = dao.get();
			request.setAttribute("cars", cars);
			DeviceDAO dao1 = new DeviceDAO();
			List<Device> devices = dao1.get();
			request.setAttribute("devices", devices);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Ticket/add-ticket.jsp");
			rd.forward(request, response);			
		} catch (Exception e) {
			response.sendRedirect("/PeterParker/ticket");
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}		
	}
}
