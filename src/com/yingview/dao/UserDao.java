package com.yingview.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yingview.domain.User;

public interface UserDao {
	
	int regist(User user) throws SQLException;

	int active(User user) throws SQLException;

	int update(User user) throws SQLException;

	User login(String username, String passcode) throws SQLException;

}

