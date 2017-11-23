package com.yingview.service;

import java.sql.SQLException;
import java.util.List;

public interface QueryService {

	List<?> navlist() throws SQLException;

	List<?> typelist() throws SQLException;

}
