package com.wat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wat.service.MyMailService;

/**
 * 类说明
 * 
 * @author Wutao
 * @version 2017年8月11日 下午10:53:13
 * @see
 * @since
 */
@Service
public class MyMailServiceImpl implements MyMailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;

	@Override
	public void sendSingle(String reciver, String subject, String content) {
		simpleMailMessage.setTo(reciver);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		mailSender.send(simpleMailMessage);
	}

}
