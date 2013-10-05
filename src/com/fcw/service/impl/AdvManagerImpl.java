/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.AdvDao;
import com.fcw.domain.Adv;
import com.fcw.service.AdvManager;


public class AdvManagerImpl implements AdvManager {
	
	
	private AdvDao advDao;
	
	public void setAdvDao(AdvDao advDao){
		this.advDao = advDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Adv adv) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		adv.setUploadTime(create_date);
		advDao.save(adv);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		advDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Adv get(Integer id){
		return advDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Adv adv) {
		// TODO Auto-generated method stub
		advDao.update(adv);
	}



	/* 
	 * 查询所有
	 */
	public List<Adv> findAll() {
		return  advDao.findByHql("from Adv");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Adv user, int pageNo, int pageSize) {
		String hql = " from Adv where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		
		hql += " order by id desc";
		List lst = advDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = advDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}
	
	public List findAdvByType(Integer id) {
		return advDao.findTopResult("from Adv where advType="+id+" order by id desc", 1);
	}
	
	/*
	 * 批量删除
	 */
	public void batchDelete(String ids){
		advDao.bulkUpdate("delete from Adv where id in( "+ids+" )");
	}

}
