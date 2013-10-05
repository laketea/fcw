package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-22 00:50:33
 */
public class BlogVisit
	implements Serializable
{
	
	private Integer id;  //id

	private Integer blogId;  //博客ID

	private String blogName;  //博客名称

	private Integer visitId;  //访问人ID

	private String visitName;  //访问人名称

	private String visitPhoto;  //访问人头像

	private String visiteTime;  //最近访问时间

	private Integer status;  //状态


	public BlogVisit(){
		
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

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getVisitName() {
		return visitName;
	}

	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

	public String getVisitPhoto() {
		return visitPhoto;
	}

	public void setVisitPhoto(String visitPhoto) {
		this.visitPhoto = visitPhoto;
	}

	public String getVisiteTime() {
		return visiteTime;
	}

	public void setVisiteTime(String visiteTime) {
		this.visiteTime = visiteTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}