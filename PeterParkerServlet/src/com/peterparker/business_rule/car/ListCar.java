package com.peterparker.business_rule.car;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;

public class ListCar implements Logic{
	public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
		
		
		//aqui vai a lista de carros
        System.out.println("Executando a logica e redirecionando...");
        return "Car/car-list.jsp";
    }
}
