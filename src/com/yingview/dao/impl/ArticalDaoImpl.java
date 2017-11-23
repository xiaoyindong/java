package com.yingview.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yingview.dao.ArticalDao;
import com.yingview.domain.Artical;
import com.yingview.domain.ArticalList;
import com.yingview.utils.DataSourceUtils;

public class ArticalDaoImpl implements ArticalDao {

	@Override
	public int insert(Artical artical) {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into articals values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println();
		try {
			return qr.update(sql, 
					null,
					artical.getArticalcode(),
					artical.getArticaltitle(),
					artical.getUserId(),
					artical.getTypeId(),
					artical.getArticalcontent(),
					artical.getArticalphoto(),
					artical.getArticalimages(),
					artical.getArticalcreateDate(),
					artical.getArticaltype(),
					artical.getArticalview(),
					artical.getArticalmark(),
					artical.getArticalcommentNum(),
					artical.getArticalstatus()
					);
		} catch (Exception e) {
			System.out.println("异常");
		}
		return 0;
	}

	@Override
	public int update(Artical articalinfo) {
		return 0;
	}

	@Override
	public HashMap<String, Object> querylist(String effective, String needType, int size, int current) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		StringBuilder sql = new StringBuilder("select articals.*, users.* from articals left join users on articals.userId = users.userId");
		if (needType != null && needType.equals("great")) {
			sql.append(" where articals.articalstatus = 2 order by articals.articalcreateDate desc");
		} else if (effective != null && effective.equals("y")) {
			sql.append(" where articals.articalstatus = 1 or articals.articalstatus = 2");
		}
		if (needType != null && needType.equals("new")) {
			sql.append(" order by articals.articalcreateDate desc");
		}
		if (needType != null && needType.equals("hot")) {
			sql.append(" order by articals.articalview desc");
		}
		String sqlsize = new String(sql);
		sql.append(" limit "+ (current - 1) * size +", " + size);
		String sqlreal = new String(sql);
		try {
			HashMap<String, Object> artical = new HashMap<String, Object>();
			artical.put("articalList", qr.query(sqlreal, new BeanListHandler<ArticalList>(ArticalList.class)));
			artical.put("total", qr.query(sqlsize, new BeanListHandler<ArticalList>(ArticalList.class)).size());
			return artical;
		} catch (Exception e) {
			return null;
		}
	}

//	@Override
//	public int update(String articalinfo) {
//		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
//		String sql = "update users set username = ?,password = ? ,name = ?,email = ?,telephone = ?,birthday = ?,sex = ?,state = ?,code = ? where uid = ? ";
//		return qr.update(sql,
//				user.getUsername(),
//				user.getPassword()
//				);
//	}

}
