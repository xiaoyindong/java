package com.yingview.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.yingview.domain.CustomFile;
import com.yingview.service.FileService;
import com.yingview.service.impl.FileServiceImpl;

public class DownLoad extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		FileService fs = new FileServiceImpl();
		CustomFile file = fs.query(code);
		if (file == null) {
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().print("文件不存在");
		} else {
			resp.setHeader("content-position", "attachment;filename=" + file.getFilename());
	        //设置文件MIME类型  
	        resp.setContentType(getServletContext().getMimeType(file.getFilename()));
	        //设置Content-Disposition
	        resp.setHeader("Content-Disposition", "attachment;filename="+file.getFilename());
	        //获取目标文件的绝对路径
	        String fullFileName = "/Users/xuzhifei/Documents/workspace/yingview/files/" + file.getFilename();   
	        //读取文件
	        InputStream in = new FileInputStream(fullFileName);
	        ServletOutputStream out = resp.getOutputStream();
	        IOUtils.copy(in, out);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
