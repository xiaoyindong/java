package com.yingview.service;

import com.yingview.domain.CustomFile;

public interface FileService {

	int insert(CustomFile file);
	
	CustomFile query(String code);

}
