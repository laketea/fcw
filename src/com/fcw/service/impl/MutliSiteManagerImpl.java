/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.MutliSiteDao;
import com.fcw.domain.MutliSite;
import com.fcw.service.MutliSiteManager;


public class MutliSiteManagerImpl implements MutliSiteManager {
	
	
	private MutliSiteDao mutlisiteDao;
	
	public void setMutliSiteDao(MutliSiteDao mutlisiteDao){
		this.mutlisiteDao = mutlisiteDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(MutliSite mutlisite) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		mutlisite.setCreateTime(create_date);
		mutlisiteDao.save(mutlisite);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		mutlisiteDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public MutliSite get(Integer id){
		return mutlisiteDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(MutliSite mutlisite) {
		// TODO Auto-generated method stub
		mutlisiteDao.update(mutlisite);
	}



	/* 
	 * 查询所有
	 */
	public List<MutliSite> findAll() {
		return  mutlisiteDao.findByHql("from MutliSite");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(MutliSite user, int pageNo, int pageSize) {
		String hql = " from MutliSite where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		List lst = mutlisiteDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = mutlisiteDao.findByHql(hql);
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
		mutlisiteDao.bulkUpdate("delete from MutliSite where id in( "+ids+" )");
	}

}
