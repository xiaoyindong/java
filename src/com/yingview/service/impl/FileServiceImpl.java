package com.yingview.service.impl;

import com.yingview.dao.FileDao;
import com.yingview.dao.impl.FileDaoImpl;
import com.yingview.domain.CustomFile;
import com.yingview.service.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public int insert(CustomFile file) {
		FileDao dao = new FileDaoImpl();
		return dao.insert(file);
	}

	@Override
	public CustomFile query(String code) {
		FileDao dao = new FileDaoImpl();
		return dao.query(code);
	}
}
