package org.catolicasc.peterparker.controller;

import java.util.List;

import org.catolicasc.peterparker.dao.DeviceDAO;
import org.catolicasc.peterparker.modelo.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeviceController {

	private DeviceDAO dao = null;

	public DeviceController() {
		this.dao = new DeviceDAO();
	}

	@RequestMapping("/formDevice")
	public String formulario() {
		return "device/add-device";
	}

	@RequestMapping("/adicionaDevice")
	public String adiciona(Device device) {
		System.out.println("Dispositivo adicionada é: " + device.getDescricao());
		this.dao.add(device);

		return "redirect:device";
	}

	@RequestMapping("/device")
	public ModelAndView listaDispositivos() {
		ModelAndView mv = new ModelAndView("device/list-devices");
		List<Device> devices = this.dao.get();

		mv.addObject("devices", devices);

		return mv;
	}

}
