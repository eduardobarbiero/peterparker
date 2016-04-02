package org.catolicasc.peterparker.controller;

import org.catolicasc.peterparker.dao.DeviceDAO;
import org.catolicasc.peterparker.modelo.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeviceController {

	private DeviceDAO dao = null;

	public DeviceController() {
		this.dao = new DeviceDAO();
	}

	@RequestMapping("/")
	public String formulario() {
		return "device/formulario";
	}

	@RequestMapping("/adicionaDevice")
	public String adiciona(Device device) {
		System.out.println("Dispositivo adicionada é: " + device.getDescription());
		this.dao.add(device);

		return "ticket/formulario";
	}
}
