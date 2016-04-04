package com.peterparker.business_rule.ticket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

public class AddTicketLeft implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Ticket tick = new Ticket();
		TicketDAO dao = new TicketDAO();		
		
		Device dev = new Device();
		dev.setId(Long.parseLong(request.getParameter("dispositivo_saida")));
				
		tick.setDispositivoSaida(dev);
		
		Calendar cal = Calendar.getInstance();
		//Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse();
		cal.setTime(cal.getTime());
		tick.setHoraSaida(cal);
		
		tick.setId(Long.parseLong(request.getParameter("ticket_id")));
						
		dao.update(tick);
		System.out.println("Saida de Estacionamento... ");
		return "device";
	}

}
