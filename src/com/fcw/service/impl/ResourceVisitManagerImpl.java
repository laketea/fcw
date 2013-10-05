/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.ResourceVisitDao;
import com.fcw.domain.ResourceVisit;
import com.fcw.service.ResourceVisitManager;


public class ResourceVisitManagerImpl implements ResourceVisitManager {
	
	
	private ResourceVisitDao resourcevisitDao;
	
	public void setResourceVisitDao(ResourceVisitDao resourcevisitDao){
		this.resourcevisitDao = resourcevisitDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(ResourceVisit resourcevisit) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		resourcevisit.setLastTime(create_date);
		resourcevisitDao.save(resourcevisit);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		resourcevisitDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public ResourceVisit get(Integer id){
		return resourcevisitDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(ResourceVisit resourcevisit) {
		// TODO Auto-generated method stub
		resourcevisitDao.update(resourcevisit);
	}



	/* 
	 * 查询所有
	 */
	public List<ResourceVisit> findAll() {
		return  resourcevisitDao.findByHql("from ResourceVisit");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(ResourceVisit user, int pageNo, int pageSize) {
		String hql = " from ResourceVisit where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		List lst = resourcevisitDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = resourcevisitDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}
	
	/*
	 * 批量删除
	 */
	public void batchDelete(String ids){
		resourcevisitDao.bulkUpdate("delete from ResourceVisit where id in( "+ids+" )");
	}

}
