package com.yingview.service;

import java.sql.SQLException;

import com.yingview.domain.User;

public interface UserService {

	int regist(User user) throws SQLException;

	int active(User user) throws SQLException;

	int update(User user) throws SQLException;

	User login(String username, String passcode) throws SQLException;
	
}
