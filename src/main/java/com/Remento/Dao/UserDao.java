package com.Remento.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Remento.Model.User;
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
	
	public int joinProc ( User user ) {
		
		String sql = getQuery.get("userDao.signProc");
		
		Object[] params = {
				user.getUserId(),
				user.getUserPw(),
				user.getUserName(),
				user.getUserEmail(),
				user.getZipCode(),
				user.getAdress(),
				user.getEtcAdress()
		};
		
		try {
			return jdbcTemplate.update(sql, params);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		
		return 0;
	}

}
