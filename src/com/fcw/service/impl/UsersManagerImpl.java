/**
 * 
 */
package com.fcw.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.UsersDao;
import com.fcw.domain.Users;
import com.fcw.service.UsersManager;

public class UsersManagerImpl implements UsersManager {

	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	/*
	 * 添加管
	 */
	public void add(Users users) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		users.setApyTime(create_date);
		usersDao.save(users);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		usersDao.deleteByKey(id);
	}

	/*
	 * 根据id获取实例
	 */
	public Users get(Integer id) {
		return usersDao.get(id);
	}

	/*
	 * 修改
	 */
	@Override
	public void update(Users users) {
		// TODO Auto-generated method stub
		usersDao.update(users);
	}

	/*
	 * 查询所有
	 */
	public List<Users> findAll() {
		return usersDao.findByHql("from Users");
	}

	/*
	 * 分页查询
	 */
	public Page findByPage(Users user, int pageNo, int pageSize) {
		String hql = " from Users where 1=1 ";
		if (user != null) {
			if (user.getUserGroup() != null) {
				hql += " and userGroup = " + user.getUserGroup();
			}
			if (user.getStatus() != null) {
				hql += " and status = " + user.getStatus();
			}
			if (Utils.notNull(user.getAccount())) {
				hql += " and account like '%" + user.getAccount() + "%'";
				// hql += " and companyName like '%" + user.getAccount() + "%'";
			}
		}
		List lst = usersDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = usersDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}

	public Users checkEmailExsit(String value) {
		List lst = usersDao.findByHql("from Users where email ='" + value + "'");
		return Utils.listNull(lst) ? null : (Users) lst.get(0);
	}

	public Users checkNickExsit(String value) {
		List lst = usersDao.findByHql("from Users where nick ='" + value + "'");
		return Utils.listNull(lst) ? null : (Users) lst.get(0);
	}

	public Users login(Users user) {
		return user == null ? null : ajaxLogin(user.getEmail(), user.getPassword());
	}
	
	public Users ajaxLogin(String account,String password){
		if(Utils.nullBlank(account)||Utils.nullBlank(password)){
			return null;
		}
		List lst = usersDao.findByHql("from Users where email ='" + account + "' or  nick ='"+account+"' and password='"+password+"'");
		return Utils.listNull(lst) ? null : (Users) lst.get(0);
	}

	/*
	 * 批量删除
	 */
	public void batchDelete(String ids) {
		usersDao.bulkUpdate("delete from Users where id in( " + ids + " )");
	}

}
