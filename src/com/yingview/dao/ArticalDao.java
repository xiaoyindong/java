package com.yingview.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.yingview.domain.Artical;

public interface ArticalDao {

	int insert(Artical articalinfo) throws SQLException;

	int update(Artical articalinfo);


	HashMap<String, Object> querylist(String effective, String needType, int limit, int current) throws SQLException;

}
