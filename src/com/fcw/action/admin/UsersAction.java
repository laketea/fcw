
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Users;
import com.fcw.service.UsersManager;


public class UsersAction extends BaseAction {
	
	protected UsersManager mgr;
	
	public List<Users> usersLst ;
	
	public Users users = new Users();
	
	public Integer id;
	
	public String ids;

	public void setUsersManager(UsersManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 用户列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getUsers(),pageNum, getNumPerPage());
		List<Users> ss =(List<Users>)page.getList();
		setUsersLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	public String normallist(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		getUsers().setUserGroup(WebSite.USER_GROUP_NORMAL);
		Page page = mgr.findByPage(getUsers(),pageNum, getNumPerPage());
		List<Users> ss =(List<Users>)page.getList();
		setUsersLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "normallist";
	}
	
	public String companylist(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		getUsers().setUserGroup(WebSite.USER_GROUP_COMPANY);
		getUsers().setStatus(WebSite.USER_VERITY);
		Page page = mgr.findByPage(getUsers(),pageNum, getNumPerPage());
		List<Users> ss =(List<Users>)page.getList();
		setUsersLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "companylist";
	}
	
	public String unveritylist(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		getUsers().setUserGroup(WebSite.USER_GROUP_COMPANY);
		getUsers().setStatus(WebSite.USER_UNVERITY);
		Page page = mgr.findByPage(getUsers(),pageNum, getNumPerPage());
		List<Users> ss =(List<Users>)page.getList();
		setUsersLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "unveritylist";
	}
	
	
	/*
	 * 删除用户
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加用户
	 */
	public String add(){
		mgr.add(getUsers());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑用户
	 */
	public String edit(){
		 users = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 验证用户通过
	 */
	public String verity(){
		Users adm = mgr.get(getId());
		adm.setStatus(WebSite.USER_VERITY);
		mgr.update(adm);
		return ajaxForwardSuccess("验证通过成功!");
	}
	
	/*
	 * 修改用户
	 */
	public String update(){
		Users adm = mgr.get(getId());
		users.setId(getId());
		mgr.update(users);
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


	public List<Users> getUsersLst() {
		return usersLst;
	}
	
	


	public void setUsersLst(List<Users> usersLst) {
		this.usersLst = usersLst;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
