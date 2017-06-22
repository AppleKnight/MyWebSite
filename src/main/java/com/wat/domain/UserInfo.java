package com.wat.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <用户信息>
 * 
 * @author Wat
 * @version 1.0, 2017年6月15日
 * @see
 * @since
 */
public class UserInfo implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -5177181416275736127L;
    
    private String userIPAddr;
    
    private String userName;
    
    private String userId;
    
    private Date recordTime;
    
    public String getUserIPAddr()
    {
        return userIPAddr;
    }
    
    public void setUserIPAddr(String userIPAddr)
    {
        this.userIPAddr = userIPAddr;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public Date getRecordTime()
    {
        return recordTime;
    }
    
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }
    
    public UserInfo()
    {
        super();
    }
    
    public UserInfo(String userIPAddr, String userName, String userId, Date recordTime)
    {
        super();
        this.userIPAddr = userIPAddr;
        this.userName = userName;
        this.userId = userId;
        this.recordTime = recordTime;
    }
    
    @Override
    public String toString()
    {
        return "UserInfo [userIPAddr=" + userIPAddr + ", userName=" + userName + ", userId=" + userId + ", recordTime="
            + recordTime + "]";
    }
    
}
