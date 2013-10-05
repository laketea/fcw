package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2012-11-21 23:25:11
 */
public class NewsChannel
	implements Serializable
{
	
	private Integer id;  //id

	private String name;  //频道名称

	private Integer newsCount;  //新闻数量

	private Integer status;  //状态

	private String create_time;  //创建时间
	
	public List newsLst;


	public NewsChannel(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public List getNewsLst() {
		return newsLst==null?new ArrayList():newsLst;
	}

	public void setNewsLst(List newsLst) {
		this.newsLst = newsLst;
	}
	
	


	
}