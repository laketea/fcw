/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.TenderGuestDao;
import com.fcw.domain.TenderGuest;
import com.fcw.service.TenderGuestManager;


public class TenderGuestManagerImpl implements TenderGuestManager {
	
	
	private TenderGuestDao tenderguestDao;
	
	public void setTenderGuestDao(TenderGuestDao tenderguestDao){
		this.tenderguestDao = tenderguestDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(TenderGuest tenderguest) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		tenderguest.setGuestTime(create_date);
		tenderguestDao.save(tenderguest);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		tenderguestDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public TenderGuest get(Integer id){
		return tenderguestDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(TenderGuest tenderguest) {
		// TODO Auto-generated method stub
		tenderguestDao.update(tenderguest);
	}



	/* 
	 * 查询所有
	 */
	public List<TenderGuest> findAll() {
		return  tenderguestDao.findByHql("from TenderGuest");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(TenderGuest user, int pageNo, int pageSize) {
		String hql = " from TenderGuest where 1=1 ";
		if (user != null) {

			if (user.getUserId()!=null&&user.getUserId()!=0) {
				hql += " and userId = " + user.getUserId() ;
			}
			
			if (user.getTenderId()!=null&&user.getTenderId()!=0) {
				hql += " and tenderId = " + user.getTenderId() ;
			}
		}
		hql +=" order by id desc";
		List lst = tenderguestDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = tenderguestDao.findByHql(hql);
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
		tenderguestDao.bulkUpdate("delete from TenderGuest where id in( "+ids+" )");
	}

}
