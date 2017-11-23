package com.yingview.dao;

import com.yingview.domain.CustomFile;

public interface FileDao {

	int insert(CustomFile file);

	CustomFile query(String code);

}
