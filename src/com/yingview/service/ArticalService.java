package com.yingview.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.yingview.domain.Artical;

public interface ArticalService {

	int insert(Artical artical) throws SQLException;

	int update(Artical artical);

	HashMap<String, Object> querylist(String effective, String needType, int limit, int current) throws SQLException;

}
