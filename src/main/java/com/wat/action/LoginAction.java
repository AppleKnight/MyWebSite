package com.wat.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.wat.service.UserService;

/**
 * 登录模块：qq登录 正常登录 登出
 * 
 * @author Wutao
 * @version 2017年8月3日 上午9:27:04
 * @see
 * @since
 */
@Controller
@Scope("prototype")
public class LoginAction {
	
	private Logger log = Logger.getLogger(LoginAction.class);

	@Autowired
	private UserService userService;

	/**
	 * 描述:主动从qq登录 参数：@param 返回值：void 修改人： 吴滔 P0071972 修改时间： 2017年6月26日 下午9:27:30
	 */
	@RequestMapping(value = "/beforeQQLogin")
	public void beforeQQLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 描述:qq登录成功后 是qq的回调函数 参数：@param 返回值：ModelAndView 修改人： 吴滔 P0071972 修改时间：
	 * 2017年8月4日 下午11:57:30
	 */
	@RequestMapping(value = "/QQLogin/afterLogin")
	public String afterQQLogin(HttpServletResponse response,
			HttpServletRequest request) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
		try {
			AccessToken accessTokenObj = (new Oauth())
					.getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				map.put("openID", "");
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				map.put("demo_access_token", accessToken);
				map.put("demo_token_expirein", String.valueOf(tokenExpireIn));

				// 利用获取到的accessToken 去获取当前用的openid -------- start
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				user.setOpenID(openID);
				// 利用获取到的accessToken 去获取当前用户的openid --------- end

				// out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				if (userInfoBean.getRet() == 0) {
					user.setGender(userInfoBean.getGender());
					user.setNickName(userInfoBean.getNickname());
					user.setHeadImg(userInfoBean.getAvatar().getAvatarURL100());
				} else {
					user.setOpenID("");
					// out.println("很抱歉，我们没能正确获取到您的信息，原因是： " +
					// userInfoBean.getMsg());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("user", user);
		return "redirect:/index";
	}

	/**
	 * 描述:登录按钮 主动登录 参数：@param 返回值：ModelAndView 修改人： 吴滔 P0071972 修改时间： 2017年8月3日
	 * 下午11:14:39
	 */
	@ResponseBody
	@RequestMapping(value = "/normalLogin")
	public String login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//登录信息合法校检
		if (!email.equals("") && !password.equals("")) {
			com.wat.domain.UserInfo user = userService.loginByEmail(email,
					password);
			//用户是否已经注册、存在
			if(user!=null){
				request.getSession().setAttribute("user", user);
				return "1";	
			}
			return "2";
		}
		return "0";
	}

	/**
	 * 描述:主动登出 参数：@param 返回值：ModelAndView 修改人： 吴滔 P0071972 修改时间： 2017年8月3日
	 * 下午11:15:48
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		/*
		 * com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
		 * user.setOpenID("");
		 */
		request.getSession().removeAttribute("user");
		return new ModelAndView("index");
	}

	/**
	 * 描述:普通注册 参数：@param 返回值：ModelAndView 修改人： 吴滔 P0071972 修改时间： 2017年8月14日
	 * 下午4:03:21
	 */
	@ResponseBody
	@RequestMapping(value = "/normalRegister")
	public String normalRegister(HttpServletRequest request) {
	
		String baseImgPath = request.getContextPath()+"/resources/img/personicon";
		Random rand = new Random();
		String imgIndex = String.valueOf(rand.nextInt(2)+1);
		StringBuffer headImg = new StringBuffer();
		headImg.append(baseImgPath);
		headImg.append(imgIndex);
		headImg.append(".png");
		
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		log.warn("maybe encoding false coming from here:"+nickname);
		com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
		try {
			// 校检注册信息合法
			if (!nickname.equals("") && !email.equals("")
					&& !password.equals("")) {
				user.setNickName(nickname);
				user.setPassword(password);
				user.setEmail(email);
				user.setOpenID(UUID.randomUUID().toString());
				user.setHeadImg(headImg.toString());
				// 验证邮箱是否被注册过
				if (!userService.emailExist(email)) {
					userService.addUser(user);
					request.getSession().setAttribute("user", user);
					return "1";
				} else {
					return "2";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return "0";
	}
}
