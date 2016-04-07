package com.peterparker.business_rule.device;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Device;

public class RemoveDevice implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Device car = new Device();
		DeviceDAO dao = new DeviceDAO();
		car.setId(Long.parseLong(request.getParameter("id")));
		dao.remove(car);
		System.out.println("Removendo Dispositivo... ");
		return "index.jsp";
	}

}
