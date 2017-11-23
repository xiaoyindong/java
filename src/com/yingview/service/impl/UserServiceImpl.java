package com.yingview.service.impl;

import java.sql.SQLException;

import com.yingview.dao.UserDao;
import com.yingview.dao.impl.UserDaoImpl;
import com.yingview.domain.User;
import com.yingview.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int regist(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.regist(user);
	}

	@Override
	public int active(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.active(user);
	}

	@Override
	public int update(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.update(user);
	}

	@Override
	public User login(String username, String passcode) throws SQLException {
		UserDao dao = new UserDaoImpl();
		return dao.login(username, passcode);
	}

}
