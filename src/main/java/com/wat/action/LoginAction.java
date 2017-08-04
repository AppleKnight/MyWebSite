package com.wat.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

@Controller
@Scope("prototype")
public class LoginAction
{
	@RequestMapping(value="/QQLogin/afterLogin")	
    public ModelAndView afterQQLogin(HttpServletResponse response,HttpServletRequest request){
    	
    	HashMap<String,Object> map = new HashMap<String, Object>();
    	com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

            String accessToken   = null,
                   openID        = null;
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
                OpenID openIDObj =  new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();

                user.setOpenID(openID);
                //map.put("openID", openID);
                //out.println("欢迎你，代号为 " + openID + " 的用户!");
                //request.getSession().setAttribute("demo_openid", openID);
                //out.println("<a href=" + "/shuoshuoDemo.html" +  " target=\"_blank\">去看看发表说说的demo吧</a>");
                // 利用获取到的accessToken 去获取当前用户的openid --------- end

                //out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                //System.err.println(qzoneUserInfo.toString());
                //System.err.println(userInfoBean.toString());
                if (userInfoBean.getRet() == 0) {
                	user.setGender(userInfoBean.getGender());
                	user.setNickName(userInfoBean.getNickname());
                	user.setHeadImg(userInfoBean.getAvatar().getAvatarURL100());
                	/*map.put("nickName", userInfoBean.getNickname());
                	map.put("gender", userInfoBean.getGender());
                	map.put("headImg", userInfoBean.getAvatar().getAvatarURL50());
                    out.println(userInfoBean.getNickname() + "<br/>");
                    out.println(userInfoBean.getGender() + "<br/>");
                    out.println("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
                    out.println("会员 : " + userInfoBean.isVip() + "<br/>");
                    out.println("黄钻会员： " + userInfoBean.isYellowYearVip() + "<br/>");
                    out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL30() + "/><br/>");
                    out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL50() + "/><br/>");
                    out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL100() + "/><br/>");*/
                } else {
                	user.setOpenID("");
                    //out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        request.getSession().setAttribute("user", user);
    	return new ModelAndView("index");
    }
	
	/**
	 * 描述:登录按钮  主动登录
	 * 参数：@param
	 * 返回值：ModelAndView  
	 * 修改人： 吴滔 P0071972
	 * 修改时间： 2017年8月3日 下午11:14:39
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request){
		com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
		user.setOpenID("123");
		user.setNickName("流年");
		user.setHeadImg("流年");
		user.setUserIPAddr(request.getRemoteAddr());
		request.getSession().setAttribute("user", user);
		return new ModelAndView("index");
	}
	
	/**
	 * 描述:主动登出
	 * 参数：@param
	 * 返回值：ModelAndView  
	 * 修改人： 吴滔 P0071972
	 * 修改时间： 2017年8月3日 下午11:15:48
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request){
		com.wat.domain.UserInfo user = new com.wat.domain.UserInfo();
		user.setOpenID("");
		request.getSession().setAttribute("user", user);
		return new ModelAndView("index");
	}
}
