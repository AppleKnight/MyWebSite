package com.wat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wat.dao.UserDao;
import com.wat.domain.UserInfo;
import com.wat.service.UserService;

/**
 * 用户操作 相关接口实现类
 * 
 * @author Wutao
 * @version 2017年8月14日 下午12:59:12
 * @see
 * @since
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public int addUser(UserInfo user) {
		return userDao.addUser(user);
	}

	public int promiseMe(UserInfo user) {
		return userDao.promiseMe(user);
	}

	public boolean emailExist(String email) {
		return userDao.emailExist(email);
	}

	public UserInfo loginByEmail(String email, String password) {
		return userDao.loginByEmail(email, password);
	}

}
