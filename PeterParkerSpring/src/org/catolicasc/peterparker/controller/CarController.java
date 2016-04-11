package org.catolicasc.peterparker.controller;

import java.util.List;

import org.catolicasc.peterparker.dao.CarDAO;
import org.catolicasc.peterparker.modelo.Car;
import org.springframework.stereotype.Controller;
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
		return "car/add-car";
	}

	@RequestMapping("/adicionaCarro")
	public String adiciona(Car car) {
		System.out.println("Carro adicionado é: " + car.getPlaca());
		this.cDao.add(car);

		return "redirect:car";
	}

	@RequestMapping("/removeCarro")
	public String remove(Car car) {
		this.cDao.remove(car);

		return "redirect:car";
	}

	@RequestMapping("/car")
	public ModelAndView lista() {
		List<Car> cars = this.cDao.get();

		ModelAndView mv = new ModelAndView("car/list-cars");
		mv.addObject("cars", cars);

		return mv;

	}
}
