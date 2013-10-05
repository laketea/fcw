
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.UserInfo;
import com.fcw.service.UserInfoManager;


public class UserInfoAction extends BaseAction {
	
	protected UserInfoManager mgr;
	
	public List<UserInfo> userInfoLst ;
	
	public UserInfo userInfo;
	
	public Integer id;
	
	public String ids;

	public void setUserInfoManager(UserInfoManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 用户资料列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getUserInfo(),pageNum, getNumPerPage());
		List<UserInfo> ss =(List<UserInfo>)page.getList();
		setUserInfoLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除用户资料
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加用户资料
	 */
	public String add(){
		mgr.add(getUserInfo());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑用户资料
	 */
	public String edit(){
		 userInfo = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改用户资料
	 */
	public String update(){
		UserInfo adm = mgr.get(getId());
		userInfo.setId(getId());
		//userInfo.setCreateDate(userInfo.getCreateDate());
		mgr.update(userInfo);
		return ajaxForwardSuccess("修改成功!");
	}
	
	/*
	 * 批量删除
	 */
	public String batch(){
		 mgr.batchDelete(ids);	
		return ajaxForwardSuccess("操作成功!");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public List<UserInfo> getUserInfoLst() {
		return userInfoLst;
	}
	
	


	public void setUserInfoLst(List<UserInfo> userInfoLst) {
		this.userInfoLst = userInfoLst;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
