package com.yingview.service.impl;

import java.sql.SQLException;
import java.util.HashMap;

import com.yingview.dao.ArticalDao;
import com.yingview.dao.impl.ArticalDaoImpl;
import com.yingview.domain.Artical;
import com.yingview.service.ArticalService;

public class ArticalServiceImpl implements ArticalService  {

	@Override
	public int insert(Artical artical) throws SQLException {
		ArticalDao dao = new ArticalDaoImpl();
		return dao.insert(artical);
	}

	@Override
	public int update(Artical artical) {
		ArticalDao dao = new ArticalDaoImpl();
		return dao.update(artical);
	}

	@Override
	public HashMap<String, Object> querylist(String effective, String needType, int limit, int current) throws SQLException {
		ArticalDao dao = new ArticalDaoImpl();
		return dao.querylist(effective, needType, limit, current);
	}

}
