package com.yingview.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.yingview.dao.QueryDao;
import com.yingview.dao.impl.QueryDaoImpl;
import com.yingview.service.QueryService;

public class QueryServiceImpl implements QueryService {

	@Override
	public List<?> navlist() throws SQLException {
		QueryDao dao = new QueryDaoImpl();
		return dao.navlist();
	}
	public List<?> typelist() throws SQLException {
		QueryDao dao = new QueryDaoImpl();
		return dao.typelist();
	}
}
