package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2012-11-22 22:20:54
 */
public class Users
	implements Serializable
{
	
	private Integer id;  //id

	private String account;  //帐号名

	private String nick;  //昵称

	private String email;  //邮箱

	private String password;  //密码

	private String apyTime;  //申请时间

	private Integer userGroup;  //用户类型

	private Integer status;  //是否通过验证
	
	private String rePwd;
	
	private Integer vip= 0;
	
	private UserInfo userInfo;
	
	private Integer blog =0;
	
	private BlogInfo blogInfo;


	public Users(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
		
	public BlogInfo getBlogInfo() {
		return blogInfo;
	}

	public void setBlogInfo(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}

	public Integer getBlog() {
		return blog;
	}

	public void setBlog(Integer blog) {
		this.blog = blog;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApyTime() {
		return apyTime;
	}

	public void setApyTime(String apyTime) {
		this.apyTime = apyTime;
	}

	public Integer getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(Integer group) {
		this.userGroup = group;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}
	
	
	
	


	
}