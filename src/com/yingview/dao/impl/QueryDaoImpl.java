package com.yingview.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yingview.dao.QueryDao;
import com.yingview.domain.Nav;
import com.yingview.domain.Type;
import com.yingview.utils.DataSourceUtils;

public class QueryDaoImpl implements QueryDao {

	@Override
	public List<?> navlist() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from navs where navstatus = 1";
		return (List<?>) qr.query(sql, new BeanListHandler<Nav>(Nav.class));
	}
	@Override
	public List<?> typelist() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from types where typestatus = 1";
		return (List<?>) qr.query(sql, new BeanListHandler<Type>(Type.class));
	}
}
