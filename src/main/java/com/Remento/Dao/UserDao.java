package com.Remento.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Remento.Util.GetQuery;

@Component("userDao")
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	GetQuery getQuery;
	
	public int idCheck ( String userId ) {
		
		String sql = getQuery.get("userDao.idCheck");
		Object[] params = {
			userId	
		};
		
		try {
			return jdbcTemplate.queryForObject(sql, params, Integer.class);
		} catch ( DataAccessException e ) {
			e.printStackTrace();
		}
		
		return 1;
	}

}
