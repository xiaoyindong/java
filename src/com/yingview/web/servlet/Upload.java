package com.yingview.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yingview.domain.CustomFile;
import com.yingview.service.FileService;
import com.yingview.service.impl.FileServiceImpl;
import com.yingview.toweb.ReturnData;
import com.yingview.utils.UUIDUtils;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uploadPath = "/Users/xuzhifei/Documents/workspace/yingview/files"; // 上传文件的目录
	File tempPathFile;

	public Upload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String uploadPath =
		// request.getSession().getServletContext().getRealPath("/");
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> content = new HashMap<String, Object>();
		ReturnData retruedata = new ReturnData();
		File files = new File(uploadPath);
		if (!files.exists()) {
			files.mkdirs();
		}
		CustomFile file = new CustomFile();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			factory.setRepository(tempPathFile);// 设置缓冲区目录
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			Iterator<FileItem> i = items.iterator();
			String code = UUIDUtils.getCode();
			String name = null;
			file.setFilecode(code);
			FileService fs = new FileServiceImpl();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				String fileName = fi.getName();
				String[] extension = fileName.split("\\.");
				File savedFile = null;
				if (extension.length > 1) {
					name = code + '.' + extension[1];
					file.setFilename(name);
					savedFile = new File(uploadPath, name);
				} else {
					file.setFilecode(name);
					savedFile = new File(uploadPath, name);
				}
				fi.write(savedFile);
			}
			if (fs.insert(file) == 1) {
				file.setFileviewAdd("http://127.0.0.1:8080/files/" + name);
				file.setFiledownAdd("http://127.0.0.1:8080/download.json?code=" + code);
				content.put("isSuccess", true);
				content.put("message", "上传成功");
				content.put("file", file);
			} else {
				content.put("isSuccess", false);
				content.put("message", "上传失败");
			}
		} catch (Exception e) {
			content.put("isSuccess", false);
			content.put("message", "上传失败");
		}
		retruedata.setContent(content);
		response.getWriter().print(JSONObject.fromObject(retruedata));
	}

}
