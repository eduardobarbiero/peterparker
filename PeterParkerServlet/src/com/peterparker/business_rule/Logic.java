package com.peterparker.business_rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logic {
    String executa(HttpServletRequest request, 
            HttpServletResponse response)
            throws Exception;
}