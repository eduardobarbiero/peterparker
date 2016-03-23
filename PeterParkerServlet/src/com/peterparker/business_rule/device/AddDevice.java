package com.peterparker.business_rule.device;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class AddDevice implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Device dev = new Device();
		DeviceDAO dao = new DeviceDAO();
		dev.setAddress(request.getParameter("address"));
		dev.setDescription(request.getParameter("description"));
		dao.add(dev);
		System.out.println("Cadastrando Device... ");
		return "index.jsp";
	}

}
