package com.wat.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.wat.domain.UserInfo;

@Repository
public class UserDao extends BaseDao {
	/**
	 * 描述:赞赏 参数：@param 返回值：int 修改人： 吴滔 P0071972 修改时间： 2017年8月14日 下午4:36:20
	 */
	public int promiseMe(final UserInfo user) {
		String sql = "insert into demo(ipaddr,username,recordtime) values(?,?,?)";
		return getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserIPAddr());
				ps.setString(2, user.getUserName());
				ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			}
		});
	}

	public int queryByIpAddr(String addr) {
		String sql = "select count(*) from demo where ipaddr = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { addr },
				Integer.class);
	}
	
	/**
	 * 描述:根据邮箱和密码登录
	 * 参数：@param
	 * 返回值：UserInfo  
	 * 修改人： 吴滔 P0071972
	 * 修改时间： 2017年8月14日 下午9:27:39
	 */
	public UserInfo loginByEmail(String email,String password){
		String sql = "select * from user where email = ? and password = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[]{email,password}, ParameterizedBeanPropertyRowMapper.newInstance(UserInfo.class));
	}

	/**
	 * 描述:邮箱是否被注册 参数：@param 返回值：boolean 修改人： 吴滔 P0071972 修改时间： 2017年8月14日
	 * 下午4:36:10
	 */
	public boolean emailExist(String email) {
		String sql = "select count(*) from user where email = ?";
		int count = getJdbcTemplate().queryForObject(sql,
				new Object[] { email }, Integer.class);
		if (count <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 描述:新增用户 参数：@param 返回值：int 修改人： 吴滔 P0071972 修改时间： 2017年8月14日 下午4:36:14
	 */
	public int addUser(final UserInfo user) {
		String sql = "insert into user(nickname,email,password,recordtime,open_id,headimg) values (?,?,?,?,?,?)";
		return getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getNickName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				ps.setString(5, user.getOpenID());
				ps.setString(6, user.getHeadImg());
			}
		});
	}

}
