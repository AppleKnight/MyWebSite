package com.wat.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.wat.domain.UserInfo;

@Repository
public class UserDao extends BaseDao
{
    public int addUser(final UserInfo user)
    {
        String sql = "insert into demo(ipaddr,username,recordtime) values(?,?,?)";    
        return getJdbcTemplate().update(sql, new PreparedStatementSetter()
        {
            public void setValues(PreparedStatement ps)
                throws SQLException
            {
                ps.setString(1, user.getUserIPAddr());
                ps.setString(2, user.getUserName());
                ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            }
        });
    }
    
    
    public int queryByIpAddr(String addr){
        String sql="select count(*) from demo where ipaddr = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{addr}, Integer.class);
    }
    
}
