package com.wat.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@Scope("prototype")
public class IndexAction
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private FreemakerDao freemakerDao;
    
    /**
     * 描述:
     * 参数：@param
     * 返回值： ModelAndView
     * 修改人： Wat
     * 修改时间： 2017年6月20日 上午10:50:54
     */
    @RequestMapping(value="/index")
    public ModelAndView indexView(){
        return new ModelAndView("index");
    }

    /**
     * 描述:
     * 参数：@param
     * 返回值： String
     * 修改人： Wat
     * 修改时间： 2017年6月20日 上午10:50:59
     */
    @ResponseBody
    @RequestMapping(value="/promiseMe",produces="text/html;charset=UTF-8")
    public String promiseMe(HttpServletRequest request){
        String ipaddr =  request.getRemoteAddr();
        String userName = UUID.randomUUID().toString();
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        user.setUserIPAddr(ipaddr);
        /*int ipres = userDao.queryByIpAddr(ipaddr);
        if(ipres >= 1){
            return "2";
        }else{
        }*/
            int result = userDao.addUser(user);
            return String.valueOf(result);
    }
    
    /**
     * 描述:
     * 参数：@param
     * 返回值：void  
     * 修改人： 吴滔 P0071972
     * 修改时间： 2017年6月26日 下午9:27:30
     */
    @RequestMapping(value="/beforeQQLogin")
    public void beforeQQLogin(HttpServletRequest request,HttpServletResponse response){
    	 try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
    }
    
    @ResponseBody
    @RequestMapping(value="/buildpage")
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
