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
public class UserInfo implements Serializable {
	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = -5177181416275736127L;

	private String userIPAddr;// 用户的ip

	private String userName;// uuid

	private String userId;// 用户id 主键 自增

	private Date recordTime;// 记录时间

	private String nickName;// 昵称

	private String realName;// '真实'姓名

	private String gender;// sex

	private String province;// qq注册的省份

	private String city;// qq注册是城市

	private String year;// qq注册时填写的生日年份

	private String openID;// qq用户的唯一识别符

	private String headImg;// qq用户头像

	public String getUserIPAddr() {
		return userIPAddr;
	}

	public void setUserIPAddr(String userIPAddr) {
		this.userIPAddr = userIPAddr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String userIPAddr, String userName, String userId,
			Date recordTime, String nickName, String realName, String gender,
			String province, String city, String year, String openID,
			String headImg) {
		super();
		this.userIPAddr = userIPAddr;
		this.userName = userName;
		this.userId = userId;
		this.recordTime = recordTime;
		this.nickName = nickName;
		this.realName = realName;
		this.gender = gender;
		this.province = province;
		this.city = city;
		this.year = year;
		this.openID = openID;
		this.headImg = headImg;
	}

	@Override
	public String toString() {
		return "UserInfo [userIPAddr=" + userIPAddr + ", userName=" + userName
				+ ", userId=" + userId + ", recordTime=" + recordTime
				+ ", nickName=" + nickName + ", realName=" + realName
				+ ", gender=" + gender + ", province=" + province + ", city="
				+ city + ", year=" + year + ", openID=" + openID + ", headImg="
				+ headImg + "]";
	}

}
