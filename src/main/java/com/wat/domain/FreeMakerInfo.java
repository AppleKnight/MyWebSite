package com.wat.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * freemaker 实体bean
 * 
 * @author Wutao
 * @version 2017年7月12日 下午8:30:57
 * @see
 * @since
 */
public class FreeMakerInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5597003042328323531L;

	private int templateid;// 模板id
	private String templatename;// 模板要静态化的名称
	private Date createtime;// 创建模板的时间
	private String comments;// 备注
	private String sourceurl;// ftl文件路径
	private String targeturl;// 静态文件路径
	private String creatorid;// 创建者id
	private String content;// 内容

	public int getTemplateid() {
		return templateid;
	}

	public void setTemplateid(int templateid) {
		this.templateid = templateid;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSourceurl() {
		return sourceurl;
	}

	public void setSourceurl(String sourceurl) {
		this.sourceurl = sourceurl;
	}

	public String getTargeturl() {
		return targeturl;
	}

	public void setTargeturl(String targeturl) {
		this.targeturl = targeturl;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FreeMakerInfo() {
		super();
	}

	public FreeMakerInfo(int templateid, String templatename, Date createtime,
			String comments, String sourceurl, String targeturl,
			String creatorid, String content) {
		super();
		this.templateid = templateid;
		this.templatename = templatename;
		this.createtime = createtime;
		this.comments = comments;
		this.sourceurl = sourceurl;
		this.targeturl = targeturl;
		this.creatorid = creatorid;
		this.content = content;
	}

	@Override
	public String toString() {
		return "FreeMakerInfo [templateid=" + templateid + ", templatename="
				+ templatename + ", createtime=" + createtime + ", comments="
				+ comments + ", sourceurl=" + sourceurl + ", targeturl="
				+ targeturl + ", creatorid=" + creatorid + ", content="
				+ content + "]";
	}

}
