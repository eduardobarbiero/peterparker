package com.peterparker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.business_rule.car.ListCar;
import com.peterparker.models.Car;

@SuppressWarnings("serial")
@WebServlet("/car")
public class CarController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		System.out.println(parametro);
		String action = "com.peterparker.business_rule.car." + parametro;
		if (action != "" || !action.isEmpty()) {
			try {
				Class<?> classe = Class.forName(action);
				Logic logica = (Logic) classe.newInstance();
				String pagina = logica.executa(request, response);
				request.getRequestDispatcher("/WEB-INF/Car/" + pagina).forward(request, response);
			} catch (Exception e) {
				throw new ServletException("A lógica de negócios causou uma exceção", e);
			}
		} else {
			try {
				request.getRequestDispatcher("/WEB-INF/Car/index.jsp").forward(request, response);
			} catch (Exception e) {
				throw new ServletException("A lógica de negócios causou uma exceção", e);
			}
		}

	}
}
