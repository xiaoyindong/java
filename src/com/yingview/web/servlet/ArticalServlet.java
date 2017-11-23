package com.yingview.web.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yingview.domain.Artical;
import com.yingview.service.ArticalService;
import com.yingview.service.impl.ArticalServiceImpl;
import com.yingview.toweb.ReturnData;
import com.yingview.utils.UUIDUtils;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Artical
 */
public class ArticalServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Artical artical = new Artical();
		String articalinfo = req.getParameter("content");
		BeanUtils.populate(artical, JSONObject.fromObject(articalinfo));
		artical.setArticalcode(UUIDUtils.getCode());
		String type = req.getParameter("type");
		if (type.equals("submit")) {
			artical.setArticalcreateDate(System.currentTimeMillis());
			artical.setArticalstatus(1);
		} else {
			artical.setArticalstatus(0);
		}
		ArticalService as = new ArticalServiceImpl();
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		if (artical.getArticalId() == 0) {
			if (as.insert(artical) == 1) {
				content.put("isSuccess", true);
				content.put("message", "操作成功");
			} else {
				content.put("isSuccess", false);
				content.put("message", "操作失败");
			}
			// 新增
		} else {
			if (as.update(artical) == 1) {
				content.put("isSuccess", true);
				content.put("message", "操作成功");
			} else {
				content.put("isSuccess", false);
				content.put("message", "操作失败");
			}
			// 编辑
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}
	public void querylist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String effective = req.getParameter("effective");
		String needType = req.getParameter("needType");
		int current = 1;
		if (req.getParameter("current") != null) {
			current = Integer.parseInt(req.getParameter("current"));
		}
		int size = 40;
		if (req.getParameter("size") != null) {
			size = Integer.parseInt(req.getParameter("size"));
		}
		Map<String,Object> content = new HashMap<String,Object>();
		ReturnData retruedata = new ReturnData();
		ArticalService as = new ArticalServiceImpl();
		HashMap<String, Object> articallist = as.querylist(effective, needType, size, current);
		if (articallist == null) {
			content.put("isSuccess", false);
			content.put("message", "操作失败");
		} else {
			content.put("isSuccess", true);
			content.put("message", "操作成功");
			content.put("retValue", articallist);
		}
		retruedata.setContent(content);
		resp.getWriter().print(JSONObject.fromObject(retruedata));
	}
}
