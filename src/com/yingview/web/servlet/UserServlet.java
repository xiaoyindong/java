package com.yingview.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yingview.domain.User;
import com.yingview.service.UserService;
import com.yingview.service.impl.UserServiceImpl;
import com.yingview.toweb.ReturnData;
import com.yingview.utils.MD5Utils;
import com.yingview.utils.MailUtils;
import com.yingview.utils.UUIDUtils;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	
	public void regist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = new User();
		String userinfo = req.getParameter("content");
		BeanUtils.populate(user, JSONObject.fromObject(userinfo));
		user.setUsercode(UUIDUtils.getCode());
		user.setActivecode(UUIDUtils.getCode());
		user.setPasscode(MD5Utils.md5(user.getPassword()));
		UserService us = new UserServiceImpl();
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		user.setUsercreatetime(System.currentTimeMillis());
		if (us.regist(user) == 1) {
			req.getSession().setAttribute("user", user);
			content.put("isSuccess", true);
			content.put("message", "注册成功");
			content.put("user", user);
		} else {
			req.getSession().invalidate();
			content.put("isSuccess", false);
			content.put("message", "用户名或昵称已被占用");
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}
	
	public String active(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		User user = new User();
		BeanUtils.populate(user, req.getParameterMap());
		UserService us = new UserServiceImpl();
		if (user.getUsercode() == null || user.getActivecode() == null) {
			resp.getWriter().print("激活失败!");
			return null;
		}
		if (us.active(user) == 1) {
			resp.getWriter().print("激活成功!");
			return null;
		} else {
			resp.getWriter().print("激活失败!");
			return null;
		}
		
	}
	public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username = req.getParameter("username");
		String passcode = MD5Utils.md5(req.getParameter("password"));
		UserService us = new UserServiceImpl();
		User user = us.login(username, passcode);
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		if (user == null) {
			content.put("isSuccess", false);
			content.put("message", "用户名或密码错误");
		} else {
			req.getSession().setAttribute("user", user);
			content.put("isSuccess", true);
			content.put("message", "登录成功");
			content.put("user", user);
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.getSession().invalidate();
		// resp.sendRedirect(req.getContextPath());
	}
	
	public String index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		return "index.html";
	}
}
