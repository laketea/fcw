/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.TenderDao;
import com.fcw.domain.Tender;
import com.fcw.service.TenderManager;


public class TenderManagerImpl implements TenderManager {
	
	
	private TenderDao tenderDao;
	
	public void setTenderDao(TenderDao tenderDao){
		this.tenderDao = tenderDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Tender tender) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		tender.setPbTime(create_date);
		tenderDao.save(tender);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		tenderDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Tender get(Integer id){
		return tenderDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Tender tender) {
		// TODO Auto-generated method stub
		tenderDao.update(tender);
	}



	/* 
	 * 查询所有
	 */
	public List<Tender> findAll() {
		return  tenderDao.findByHql("from Tender");
	}
	
	public List getDfRecommendList(Integer num){
		return tenderDao.findTopResult("from Tender where dfRecmd =1 and status=0 order by dfSortNum asc and id desc ",num);
	}
	
	public List getNewestList(Integer num){
		return tenderDao.findTopResult("from Tender where  status=0 order by  id desc ",num);
	}
	
	public List getHotList(Integer num){
		return tenderDao.findTopResult("from Tender where  status=0 order by  viewCount desc ",num);
	}
	
	public List getNewestSucessedTender(Integer num){
		return tenderDao.findTopResult("from Tender where status = 1 order by id desc",num);	
	}
	
	/*
	 * 分页查询
	 */
	public Page findByPage(Tender user, int pageNo, int pageSize) {
		String hql = " from Tender where 1=1 ";
		if (user != null) {
			if (Utils.notNull(user.getName())) {
				hql += " and name like '%" + user.getName() + "%'";
			}
			
			if (user.getAuthorId()!=null&&user.getAuthorId()!=0) {
				hql += " and authorId  =" + user.getAuthorId() ;
			}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		}
		hql+=" order by overdue asc , id desc";
		List lst = tenderDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = tenderDao.findByHql(hql);
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
		tenderDao.bulkUpdate("delete from Tender where id in( "+ids+" )");
	}

}
