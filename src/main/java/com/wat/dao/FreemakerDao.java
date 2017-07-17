package com.wat.dao;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.wat.domain.FreeMakerInfo;

/**
 * 类说明
 * @author Wutao
 * @version 2017年7月12日 下午8:59:34
 * @see
 * @since
 */
@Repository
public class FreemakerDao extends BaseDao{

	public FreeMakerInfo querySingleFreemaker(){
        String sql="select templateid,templatename,createtime,comments,sourceurl,targeturl,creatorid,content from template where templateid = 1";
        return getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(FreeMakerInfo.class));
    }
}
