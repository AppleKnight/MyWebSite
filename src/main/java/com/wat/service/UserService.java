package com.wat.service;

import com.wat.domain.UserInfo;

/**
 * 用户操作  相关接口
 * @author Wutao
 * @version 2017年8月14日 下午12:57:29
 * @see
 * @since
 */
public interface UserService {
	
	int addUser(UserInfo user);
	
	int promiseMe(UserInfo user);
	
	boolean emailExist(String email);
	
	UserInfo loginByEmail(String email,String password);
}
