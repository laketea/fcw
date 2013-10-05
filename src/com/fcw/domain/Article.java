package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fcw.common.Utils;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-21 23:54:15
 */
public class Article
	implements Serializable
{
	
	private Integer id;  //id

	private Integer blogId;  //博客ID

	private String blogName;  //博客名称

	private String title;  //标题

	private String content;  //内容

	private String phTime;  //发布时间

	private Integer view_count = 0;  //阅读次数

	private Integer catalogId;  //分类ID

	private String catalogName;  //分类名称

	private Integer status;  //状态
	
	private Integer power; //权限
	
	private String s_content;


	public Article(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

	public String getS_content() {
		
		if(Utils.nullBlank(s_content)||s_content.length()<100){
			return s_content;
		}else{
			return s_content.substring(0,100)+"...";
		}
		
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
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

	public String getPhTime() {
		return phTime;
	}

	public void setPhTime(String phTime) {
		this.phTime = phTime;
	}

	public Integer getView_count() {
		return view_count;
	}

	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}