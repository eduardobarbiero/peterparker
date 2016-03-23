package com.peterparker.business_rule.device;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peterparker.business_rule.Logic;
import com.peterparker.models.Car;

public class Index implements Logic {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {				
		return "index.jsp";
	}

}
