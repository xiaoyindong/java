package com.yingview.web.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yingview.service.QueryService;
import com.yingview.service.impl.QueryServiceImpl;
import com.yingview.toweb.ReturnData;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Nav
 */
public class Query extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void navlist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		QueryService qs = new QueryServiceImpl();
		List<?> navList = qs.navlist();
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		if (navList == null) {
			content.put("isSuccess", false);
			content.put("message", "查询失败");
		} else {
			content.put("isSuccess", true);
			content.put("message", "查询成功");
			content.put("navList", navList);
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}
	public void typelist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		QueryService qs = new QueryServiceImpl();
		List<?> typeList = qs.typelist();
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		if (typeList == null) {
			content.put("isSuccess", false);
			content.put("message", "查询失败");
		} else {
			content.put("isSuccess", true);
			content.put("message", "查询成功");
			content.put("typeList", typeList);
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}

}
