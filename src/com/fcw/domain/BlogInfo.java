package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-21 23:35:52
 */
public class BlogInfo
	implements Serializable
{
	
	private Integer id;  //id

	private Integer userId;  //用户ID

	private String userName;  //用户名称

	private String blogKey;  //博客唯一标识

	private String age;  //年龄

	private String male;  //性别
	
	private String companyName;//公司名字
	
	private String createTime;
	
	private String photo;//头像
	
	//访问以及具体数据
	private Integer view_count = 0;
	
//	private Integer friend_count;
//	
//	private Integer art_count;

	private Integer status;  //状态


	public BlogInfo(){
		
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public Integer getView_count() {
		return view_count;
	}



	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}



//	public Integer getFriend_count() {
//		return friend_count;
//	}
//
//
//
//	public void setFriend_count(Integer friend_count) {
//		this.friend_count = friend_count;
//	}
//
//
//
//	public Integer getArt_count() {
//		return art_count;
//	}
//
//
//
//	public void setArt_count(Integer art_count) {
//		this.art_count = art_count;
//	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getBlogKey() {
		return blogKey;
	}

	public void setBlogKey(String blogKey) {
		this.blogKey = blogKey;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}