package com.yingview.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Class clazz = this.getClass();
		String method = req.getParameter("method");
		if (method == null) {
			method = "index";
		}
		Method func = null;
		try {
			func = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = null;
		try {
			s = (String) func.invoke(this, req, resp);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( s != null) {
			req.getRequestDispatcher(s).forward(req, resp);
		}
	}
}
