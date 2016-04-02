package org.catolicasc.peterparker.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.catolicasc.peterparker.dao.CarDAO;
import org.catolicasc.peterparker.dao.DeviceDAO;
import org.catolicasc.peterparker.dao.TicketDAO;
import org.catolicasc.peterparker.modelo.Car;
import org.catolicasc.peterparker.modelo.Device;
import org.catolicasc.peterparker.modelo.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {
	private TicketDAO tDao;
	private CarDAO cDao;
	private DeviceDAO dDao;

	public TicketController() {
		this.cDao = new CarDAO();
		this.tDao = new TicketDAO();
		this.dDao = new DeviceDAO();
	}

	@RequestMapping("/formTicket")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("ticket/formulario");
		ArrayList<Device> devices = this.dDao.get();

		mv.addObject("devices", devices);

		return mv;
	}

	@RequestMapping("/adicionaTicket")
	public String adicionaTicket(@ModelAttribute Ticket ticket) {

		Ticket existsTicket = this.tDao.getByBoard(ticket.getCar().getBoard());

		// Caso existir carro com a placa cadastrado, faz update.
		if (existsTicket.getCar().getBoard() != null) {
			Car car = new Car();
			car.setId(existsTicket.getCar().getId());
			ticket.setCar(car);
			ticket.setHoraSaida(Calendar.getInstance());
			Device device = this.dDao.getDeviceById(ticket.getDispositivoEntrada().getId());
			ticket.setDispositivoSaida(device);
			ticket.setId(this.tDao.getById(existsTicket.getCar().getBoard()).getId());

			this.tDao.update(ticket);
		} else {
			// Caso contrário, cria um novo ticket.
			this.cDao.add(ticket.getCar());
			Car car = this.cDao.getIdByBoard(ticket.getCar().getBoard());
			ticket.setCar(car);
			ticket.setHoraEntrada(Calendar.getInstance());
			Device device = this.dDao.getDeviceById(ticket.getDispositivoEntrada().getId());
			ticket.setDispositivoEntrada(device);
			this.tDao.add(ticket);
		}

		return "redirect:lista";
	}

	@RequestMapping("/lista")
	public ModelAndView retornaLista() {
		ModelAndView mv = new ModelAndView("ticket/lista");
		List<Ticket> tickets = this.tDao.getList();

		mv.addObject("tickets", tickets);

		return mv;
	}
}
