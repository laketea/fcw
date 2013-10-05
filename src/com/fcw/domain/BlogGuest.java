package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-22 00:59:54
 */
public class BlogGuest
	implements Serializable
{
	
	private Integer id;  //id

	private Integer blogId;  //博客ID

	private String blogName;  //博客名称

	private Integer guestId;  //留言人ID

	private String guestName;  //留言人名称

	private String guestPhoto;  //留言人头像

	private String guestTime;  //留言时间

	private String title;  //留言标题

	private String content;  //留言内容

	private Integer status;  //状态


	public BlogGuest(){
		
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

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestPhoto() {
		return guestPhoto;
	}

	public void setGuestPhoto(String guestPhoto) {
		this.guestPhoto = guestPhoto;
	}

	public String getGuestTime() {
		return guestTime;
	}

	public void setGuestTime(String guestTime) {
		this.guestTime = guestTime;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}