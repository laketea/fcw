package com.fcw.action.front;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.fcw.common.ActionMsg;
import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.UserInfoManager;
import com.fcw.service.UsersManager;


public class UserAction extends BaseFrontAction {
	
	

	protected UsersManager mgr;
	
	protected UserInfoManager infomgr;
	
	protected BlogInfoManager bgmgr;
	

	
	private Users user;
	
	private UserInfo userInfo;
	

	public void setUsersManager(UsersManager mgr) {
		this.mgr = mgr;
	}	
	
	public void setUserInfoManager(UserInfoManager mgr) {
		this.infomgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bgmgr = mgr;
	}

	
	
	//验证邮箱是否存在
	public void checkEmailExsit(){
		responseString(mgr.checkEmailExsit(getParameter("email"))!=null?ActionMsg.USER_EMAIL_EXSIT:ActionMsg.USER_REG_CHECK_TRUE);
	}
	
	//验证昵称是否存在
	public void checkNickExsit(){
		 responseString(mgr.checkNickExsit(getParameter("nick"))!=null?ActionMsg.USER_NICK_EXSIT:ActionMsg.USER_REG_CHECK_TRUE);
	}
	
	//注册
	public String reg(){
		
		if(!checkSecurCode()){//验证码处理
			errMsg =ActionMsg.USER_CODE_NOT_EQUAL;
			return "input";
		}
		
		
		user.setUserGroup(0);
		if(!Utils.notNull(user.getPassword())||!Utils.notNull(user.getRePwd())||!user.getRePwd().equals(user.getPassword())){
			errMsg =ActionMsg.USER_PWD_NOT_EQUAL;
			return "input";
		}
		if(Utils.nullBlank(user.getNick())||Utils.nullBlank(user.getEmail())||userInfo.getCompanyId()==null||Utils.nullBlank(userInfo.getCompanyName())){
			errMsg =ActionMsg.USERINFOR_NOT_COMPLETE;
			return "input";
		}
		if(mgr.checkEmailExsit(user.getEmail())!=null){
			errMsg =ActionMsg.USER_EMAIL_EXSIT;
			return "input";
		}
		if(mgr.checkNickExsit(user.getNick())!=null){
			errMsg =ActionMsg.USER_NICK_EXSIT;
			return "input";
		}
		
		//如果为公司用户，则默认没有通过验证
		if(user.getUserGroup()==WebSite.USER_GROUP_COMPANY){
			user.setStatus(WebSite.USER_UNVERITY);
		}else{//如果为个人用户则默认通过验证
			user.setStatus(WebSite.USER_VERITY);
		}
		
		//NEED
		
		user.setUserInfo(userInfo);
		userInfo.setUsers(user);
		mgr.add(user);
		infomgr.add(userInfo);
		this.getSession().setAttribute("login", "1");
		this.getSession().setAttribute("user", user);
		return "usercenter";
	}
	
	//ajax登录
	public void ajaxLogin() {
		String req = "0";
		if(!checkSecurCode()){
			req = "2";
			responseString(req);
			return;
		}
		
		Users nuser = mgr.ajaxLogin(getParameter("name"),getParameter("pwd"));
		if (nuser != null) {
			req = "1";
			if(nuser.getBlog()!=null&&nuser.getBlog()!=0){
				nuser.setBlogInfo(bgmgr.get(nuser.getBlog()));
			}
			
			this.getSession().setAttribute("login", "1");
			this.getSession().setAttribute("user", nuser);
			
		}else{
			getSession().invalidate();
		}
		responseString(req);
	}
	
	//普通登录
	public String login() {
		Users nuser = mgr.login(user);
		String req = "0";
		if(!checkSecurCode()){
			req = "2";
		}
		
		
		String rtView ="";
		if (nuser != null) {
			req = "1";
			if(nuser.getBlog()!=null&&nuser.getBlog()!=0){
				nuser.setBlogInfo(bgmgr.get(nuser.getBlog()));
			}
			this.getSession().setAttribute("login", "1");
			this.getSession().setAttribute("user", nuser);
			rtView = "usercenter";
		}else{
			this.errMsg ="用户名或密码错误!";
			rtView ="logininput";
		}
		return rtView;
	}
	
	//判断验证码
	public boolean checkSecurCode(){
		String random=(String)(this.getSession().getAttribute("random"));  
		String code = this.getParameter("code");
		if(!Utils.notNull(code)||!random.equals(code)){
			return false;
		}else{
			return true;
		}
	}
	
	//推出登录
	public String loginOut(){
		 getSession().invalidate();
		 return "index";
		
	}
	
	

	

	public Users getUser() {
		return user;
	}
	


	public void setUser(Users user) {
		this.user = user;
	}

	public UserInfo getUserInfo() {
		return userInfo;

	}
	
	
	public UserInfo getUsers(){
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	


}
