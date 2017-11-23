package com.yingview.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yingview.dao.UserDao;
import com.yingview.domain.User;
import com.yingview.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {
	@Override
	public int regist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		if (query(user, qr) == null) {
			Regist regist = new Regist(user, qr);
			regist.start();
			return 1;
		} else {
			return 0;
		}
	}

	public User query(User user, QueryRunner qr) throws SQLException {
		String sql = "select * from users where username = ? or nickname = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getNickname());
	}

	@Override
	public int active(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update users set status = ?, activecode = ?  where code = ? and activecode = ? ";
		return qr.update(sql,
				1,
				null,
				user.getUsercode(),
				user.getActivecode()
				);
	}
	@Override
	public int update(User user) throws SQLException  {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update users set username = ?,password = ? ,name = ?,email = ?,telephone = ?,birthday = ?,sex = ?,state = ?,code = ? where uid = ? ";
		return qr.update(sql,
				user.getUsername(),
				user.getPassword()
				);
	}

	@Override
	public User login(String username, String passcode) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from users where username = ? and passcode = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), username, passcode);
	}
}
