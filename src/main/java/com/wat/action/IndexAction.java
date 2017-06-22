package com.wat.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wat.dao.UserDao;
import com.wat.domain.UserInfo;

@Controller
@Scope("prototype")
public class IndexAction
{
    @Autowired
    private UserDao userDao;
    
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
    
}
