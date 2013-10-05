package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-06 23:09:07
 */
public class Comment
	implements Serializable
{
	
	private Integer id;  //id

	private String title;  //标题

	private String content;  //内容

	private Integer userId;  //用户ID

	private String userName;  //用户名

	private String pbTime;  //发布时间
	
	private Integer sourceId;// 来源id
	
	private Integer typeId;//类型    1----新闻评论  2---资料

	private Integer status;  //状态


	public Comment(){
		
	}
	
	
	
	public Integer getTypeId() {
		return typeId;
	}



	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}



	public Integer getSourceId() {
		return sourceId;
	}



	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPbTime() {
		return pbTime;
	}

	public void setPbTime(String pbTime) {
		this.pbTime = pbTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}