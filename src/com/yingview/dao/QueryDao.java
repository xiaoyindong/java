package com.yingview.dao;

import java.sql.SQLException;
import java.util.List;

public interface QueryDao {

	List<?> navlist() throws SQLException;

	List<?> typelist() throws SQLException;

}
