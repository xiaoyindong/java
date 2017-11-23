package com.yingview.dao.impl;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yingview.dao.FileDao;
import com.yingview.domain.CustomFile;
import com.yingview.domain.User;
import com.yingview.utils.DataSourceUtils;
import com.yingview.utils.MailUtils;

public class FileDaoImpl implements FileDao {

	@Override
	public int insert(CustomFile file) {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into files values(?, ?, ?, ?, ?, ?)";
		try {
			return qr.update(sql, null, file.getFilecode(), file.getFilename(), file.getUserId(), file.getFilemime(), file.getArticalId());
		} catch (Exception e) {
			System.out.println("异常");
		}
		return 0;
	}

	@Override
	public CustomFile query(String code) {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from files where code = ?";
		try {
			return qr.query(sql, new BeanHandler<>(CustomFile.class), code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
