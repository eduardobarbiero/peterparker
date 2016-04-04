package com.peterparker.business_rule.device;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.dao.CarDAO;
import com.peterparker.dao.DeviceDAO;
import com.peterparker.models.Car;
import com.peterparker.models.Device;

public class ListDevice implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeviceDAO dao = new DeviceDAO();
		List<Device> devices = dao.get();
		request.setAttribute("devices", devices);
		//request.getRequestDispatcher("/WEB-INF/Device/list-devices.jsp").forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Device/list-devices.jsp");
		rd.forward(request, response);
		return "device";
	}

}
