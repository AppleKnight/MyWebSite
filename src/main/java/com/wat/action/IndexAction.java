package com.wat.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import com.wat.dao.FreemakerDao;
import com.wat.dao.UserDao;
import com.wat.domain.FreeMakerInfo;
import com.wat.domain.UserInfo;
import com.wat.freemaker.FreemakerTools;
import com.wat.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 初始化模块
 * 
 * @author Wutao
 * @version 2017年8月3日 上午9:27:04
 * @see
 * @since
 */
@Controller
@Scope("prototype")
public class IndexAction
{
    @Autowired
    private UserService userService;
    @Autowired
    private FreemakerDao freemakerDao;
    
    /**
     * 描述:首页请求
     * 参数：@param
     * 返回值： ModelAndView
     * 修改人： Wat
     * 修改时间： 2017年6月20日 上午10:50:54
     */
    @RequestMapping(value="/index")
    @ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = String.class, notes = "根据用户名获取用户对象")
    public ModelAndView indexView(HttpServletRequest request){
    	UserInfo user = (UserInfo) request.getSession().getAttribute("user");
    	if(user == null){
    		user = new UserInfo();
    	}
		request.getSession().setAttribute("user", user);
        return new ModelAndView("index");
    }

    /**
     * 描述:赞赏功能
     * 参数：@param
     * 返回值： String
     * 修改人： Wat
     * 修改时间： 2017年6月20日 上午10:50:59
     */
    @ResponseBody
    @RequestMapping(value="/promiseMe",produces="text/html;charset=UTF-8")
    @ApiOperation(value = "赞赏功能", httpMethod = "GET", notes = "赞赏功能")
    public String promiseMe(HttpServletRequest request){
        String ipaddr =  request.getRemoteAddr();
        String userName = UUID.randomUUID().toString();
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        user.setUserIPAddr(ipaddr);
        int result = userService.promiseMe(user);
        return String.valueOf(result);
    }
    
    /**
     * 描述:freemaker 控制器
     * 参数：@param
     * 返回值：String  
     * 修改人： 吴滔 P0071972
     * 修改时间： 2017年8月5日 上午12:08:55
     */
    @ResponseBody
    @RequestMapping(value="/buildpage")
    @ApiOperation(value = "freemaker 控制器", httpMethod = "POST", notes = "freemaker 控制器")
    public String createStaticPage(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	FreeMakerInfo freeinfo =  freemakerDao.querySingleFreemaker();
    	System.err.println(freeinfo.toString());
    	FreemakerTools ft = new FreemakerTools();
    	String filename = freeinfo.getTemplatename() + ".html";
    	map.put("freemakertitle", "测试FreeMaker");
    	map.put("parameters", "1");
    	try {
			ft.initBuildStaticPage(freeinfo.getSourceurl(), freeinfo.getTargeturl(), filename, map, request);
		} catch (IOException e) {
			e.printStackTrace();
			return "Not done!";
		}
    	return "done!";
    }
    
}
