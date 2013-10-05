package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-22 01:14:30
 */
public class BlogComment
	implements Serializable
{
	
	private Integer id;  //id

	private Integer blogId;  //博客ID

	private String blogName;  //博客名称

	private String title;  //内容

	private String content;  //内容

	private Integer cmtId;  //评论人ID

	private String cmtName;  //评论人名称

	private String cmtPhoto;  //评论人头像

	private String cmtTime;  //评论时间

	private Integer status;  //状态


	public BlogComment(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCmtId() {
		return cmtId;
	}

	public void setCmtId(Integer cmtId) {
		this.cmtId = cmtId;
	}

	public String getCmtName() {
		return cmtName;
	}

	public void setCmtName(String cmtName) {
		this.cmtName = cmtName;
	}

	public String getCmtPhoto() {
		return cmtPhoto;
	}

	public void setCmtPhoto(String cmtPhoto) {
		this.cmtPhoto = cmtPhoto;
	}

	public String getCmtTime() {
		return cmtTime;
	}

	public void setCmtTime(String cmtTime) {
		this.cmtTime = cmtTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}