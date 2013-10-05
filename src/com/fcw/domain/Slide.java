package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-02-20 16:34:11
 */
public class Slide
	implements Serializable
{
	
	private Integer id;  //id

	private String title;  //标题

	private String photo;  //图片地址

	private String url;  //链接

	private Integer slideNum;  //排序

	private String slideType;  //分类

	private Integer status;  //状态

	private String createTime;  //上传时间


	public Slide(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSlideNum() {
		return slideNum;
	}

	public void setSlideNum(Integer slideNum) {
		this.slideNum = slideNum;
	}

	public String getSlideType() {
		return slideType;
	}

	public void setSlideType(String slideType) {
		this.slideType = slideType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	
}