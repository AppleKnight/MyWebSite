package com.wat.action;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wat.domain.UserInfo;
import com.wat.service.MyMailService;
import com.wordnik.swagger.annotations.ApiOperation;

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

	@Autowired
	private MyMailService myMailService;
	
	/**
	 * 描述:进入个人主页,在session中校检用户是否存在，不存在就跳转回首页
	 * 参数：@param
	 * 返回值：ModelAndView  
	 * 修改人： 吴滔 P0071972
	 * 修改时间： 2017年8月14日 下午9:05:58
	 */
	@ApiOperation(value="进入个人主页",notes="进入个人主页,在session中校检用户是否存在，不存在就跳转回首页",httpMethod="GET")
	@RequestMapping(value = "/personal")
	public String personalView(HttpServletRequest request) {
		com.wat.domain.UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		if(user == null){
			return "redirect:/index";
		}
		request.setAttribute("user", user);	
		return "personal";
	}
	
	/**
	 * 描述:使用邮箱发送验证码
	 * 参数：@param
	 * 返回值：String  
	 * 修改人： 吴滔 P0071972
	 * 修改时间： 2017年8月21日 下午12:35:28
	 */
	@ResponseBody
	@RequestMapping(value = "/getIdentifyCode", produces = "text/html;charset=UTF-8")
	@ApiOperation(value="使用邮箱发送验证码",notes="使用邮箱发送验证码",httpMethod="GET")
	public String getIdentifyCode(HttpServletRequest request) {
		String email = request.getParameter("email");

		try {
			myMailService.sendSingle("810963554@qq.com", "test", "test");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			return "0";
		}
		return "1";
	}
	
	

}
