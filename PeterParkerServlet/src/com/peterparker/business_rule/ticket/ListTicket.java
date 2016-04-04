package com.peterparker.business_rule.ticket;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.dao.TicketDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;
import com.peterparker.models.Ticket;

public class ListTicket implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TicketDAO dao = new TicketDAO();
		List<Ticket> tickets = dao.getList();		
		request.setAttribute("tickets", tickets);
		
		TicketDAO dao1 = new TicketDAO();
		List<Ticket> tickets_saida = dao1.getListLeft();		
		request.setAttribute("tickets_saida", tickets_saida);	
		
		DeviceDAO dao_device = new DeviceDAO();
		List<Device> devices = dao_device.get();
		request.setAttribute("devices", devices);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Ticket/list-tickets.jsp");
		rd.forward(request, response);
		return "tickets";
	}

}
