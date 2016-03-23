package com.peterparker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;

@SuppressWarnings("serial")
@WebServlet("/device")
public class DeviceController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("action") != null ? request.getParameter("action") : "";

		// temp
		int statico = request.getParameter("static") != null ? Integer.parseInt(request.getParameter("static")) : 0;
		if (parametro != "" || !parametro.isEmpty()) {
			if (statico == 1) {
				request.getRequestDispatcher("/WEB-INF/Device/" + parametro + ".jsp").forward(request, response);
			} else {
				String action = "com.peterparker.business_rule.device." + parametro;
				try {
					Class<?> classe = Class.forName(action);
					Logic logica = (Logic) classe.newInstance();
					String pagina = logica.executa(request, response);
					request.getRequestDispatcher("/WEB-INF/Device/" + pagina).forward(request, response);
				} catch (Exception e) {
					throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
				}
			}
		} else {
			try {
				request.getRequestDispatcher("/WEB-INF/Device/index.jsp").forward(request, response);
			} catch (Exception e) {
				throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
			}
		}
	}
}
