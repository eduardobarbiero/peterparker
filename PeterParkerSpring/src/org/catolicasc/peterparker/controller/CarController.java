package org.catolicasc.peterparker.controller;

import java.util.List;

import javax.validation.Valid;

import org.catolicasc.peterparker.dao.CarDAO;
import org.catolicasc.peterparker.modelo.Car;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	private CarDAO cDao = null;

	public CarController() {
		this.cDao = new CarDAO();
	}

	@RequestMapping("/formCarro")
	public String formulario() {
		return "carro/formulario";
	}

	@RequestMapping("/adicionaCarro")
	public String adiciona(@Valid Car car, BindingResult result) {

		if (result.hasErrors()) {
			return "formulario";
		}

		System.out.println("Conta adicionada é: " + car.getBoard());
		this.cDao.add(car);

		return "redirect:listaCarros";
	}

	@RequestMapping("/removeCarro")
	public String remove(Car car) {
		this.cDao.remove(car);

		return "redirect:listaContas";
	}

	@RequestMapping("/listaCarros")
	public ModelAndView lista() {
		List<Car> cars = this.cDao.get();

		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("cars", cars);

		return mv;

	}
}
