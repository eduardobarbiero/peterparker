package org.catolicasc.peterparker.controller;

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
		ModelAndView mv = new ModelAndView("ticket/add-ticket");

		List<Car> cars = this.cDao.findAll();
		List<Device> devices = this.dDao.findAll();

		mv.addObject("devices", devices);
		mv.addObject("cars", cars);

		return mv;
	}

	@RequestMapping("/adicionaTicket")
	public String adicionaTicket(@ModelAttribute Ticket ticket) {

		this.tDao.getById(ticket.getCarro().getId());

		// Caso contrário, cria um novo ticket.
		Car car = this.cDao.getById(ticket.getCarro().getId());
		ticket.setCarro(car);
		ticket.setHoraEntrada(Calendar.getInstance());
		Device device = this.dDao.getById(ticket.getDispositivoEntrada().getId());
		ticket.setDispositivoEntrada(device);
		this.tDao.persist(ticket);

		return "redirect:ticket";
	}

	@RequestMapping("/ticket")
	public ModelAndView retornaLista() {
		ModelAndView mv = new ModelAndView("ticket/list-tickets");
		List<Ticket> tickets = this.tDao.findAll();
		// List<Ticket> ticketsout = this.tDao.getListOut();
		List<Device> devices = this.dDao.findAll();

		mv.addObject("tickets", tickets);
		// mv.addObject("ticketsout", ticketsout);
		mv.addObject("devices", devices);

		return mv;
	}

	@RequestMapping("/alteraTicket")
	public String alteraTicket(Ticket ticket) {

		ticket.setHoraSaida(Calendar.getInstance());
		Device device = this.dDao.getById(ticket.getDispositivoSaida().getId());
		ticket.setDispositivoSaida(device);

		this.tDao.merge(ticket);
		return "redirect:ticket";
	}

	@RequestMapping("/removeTicket")
	public String remove(Ticket ticket) {
		this.tDao.remove(ticket);

		return "redirect:ticket";
	}
}
