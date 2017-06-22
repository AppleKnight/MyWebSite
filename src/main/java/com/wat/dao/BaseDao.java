package com.wat.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * dao基础类
 * 引入jdbctemplate和日志，方便子类使用
 * 
 * @author  Wat
 * @version  1.0, 2017年6月19日
 * @see 
 * @since
 */
public class BaseDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    protected Logger log = Logger.getLogger(BaseDao.class);
    
    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
