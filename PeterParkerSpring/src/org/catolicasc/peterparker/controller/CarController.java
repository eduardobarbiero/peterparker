package org.catolicasc.peterparker.controller;

import java.util.List;

import javax.validation.Valid;

import org.catolicasc.peterparker.dao.CarDAO;
import org.catolicasc.peterparker.modelo.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	private CarDAO dao = null;

	public CarController() {
		this.dao = new CarDAO();
	}

	@RequestMapping("/formCarro")
	public String formulario() {
		return "car/add-car";
	}

	@RequestMapping("/adicionaCarro")
	public String adiciona(@Valid Car car) {
		System.out.println("Carro adicionado é: " + car.getPlaca());
		this.dao.persist(car);

		return "redirect:car";
	}

	@RequestMapping("/removeCarro")
	public String remove(Car car) {
		this.dao.remove(car);

		return "redirect:car";
	}

	@RequestMapping("/car")
	public ModelAndView lista() {
		List<Car> cars = this.dao.findAll();

		ModelAndView mv = new ModelAndView("car/list-cars");
		mv.addObject("cars", cars);

		return mv;

	}
}
