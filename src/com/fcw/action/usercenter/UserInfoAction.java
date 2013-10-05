package com.fcw.action.usercenter;

import java.util.List;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Resource;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.UserInfoManager;
import com.fcw.service.UsersManager;

public class UserInfoAction extends BaseFrontAction {

	protected UsersManager mgr;
	
	protected ResourceManager rmgr;
	
	protected UserInfoManager tgmgr;
	
	protected BlogInfoManager bgmgr;

	private Users user;
	
	private BlogInfo blogInfo;
	
	private UserInfo userInfo;


	public void setResourceManager(ResourceManager mgr) {
		this.rmgr = mgr;
	}

	public void setUsersManager(UsersManager mgr) {
		this.mgr = mgr;
	}
	
	public void setUserInfoManager(UserInfoManager mgr) {
		this.tgmgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bgmgr = mgr;
	}


	public String edit() {
		user = (Users)this.getSession().getAttribute("user");
		userInfo = user.getUserInfo();
		return "edit";
	}
	
	public String save(){
		user = (Users)this.getSession().getAttribute("user");
		userInfo.setUsers(user);
		tgmgr.update(userInfo);
		user.setUserInfo(userInfo);
		return "edit";
	}
	
	
	//开通博客
	public String blog(){
		user = (Users)this.getSession().getAttribute("user");
		return "blog";
	}
	
	public String blogInit(){
		user = (Users)this.getSession().getAttribute("user");
		if(user.getBlog()==null||user.getBlog()==0){
			blogInfo = new BlogInfo();
			blogInfo.setUserId(user.getId());
			blogInfo.setUserName(user.getNick());
			bgmgr.add(blogInfo);
			user.setBlog(blogInfo.getId());
			user.setBlogInfo(blogInfo);
			mgr.update(user);
			
			if(user.getUserGroup()==1){//公司账户 则修改资源表的博客信息
				Integer resId = user.getUserInfo().getCompanyId();
				if(resId!=null&&resId!=0){
					Resource res = rmgr.get(resId);
					res.setBlogId(blogInfo.getId());
					rmgr.update(res);
				}
			}
		}
		return "blog";
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

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	
	
	



	

}
