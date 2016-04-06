package com.peterparker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;

@SuppressWarnings("serial")
@WebServlet("/device/remove")
public class RemoveDeviceController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "com.peterparker.business_rule.device.RemoveDevice";		
		try {
			Class<?> classe = Class.forName(action);
			Logic logica = (Logic) classe.newInstance();
			String pagina = logica.executa(request, response);
			response.sendRedirect("/PeterParker/device");			
		} catch (Exception e) {
			response.sendRedirect("/PeterParker/device");
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
