package com.wat.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人中心
 * 
 * @author Wutao
 * @version 2017年8月3日 上午9:27:04
 * @see
 * @since
 */
@Controller
@Scope("prototype")
public class PersonalAction {
	
	@RequestMapping(value="/personal")
	public ModelAndView personalView(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("openID", "123");
		map.put("nickName", "流年");
		
		return new ModelAndView("personal",map);
	}
	
}
