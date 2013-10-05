/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.SlideDao;
import com.fcw.domain.Slide;
import com.fcw.service.SlideManager;


public class SlideManagerImpl implements SlideManager {
	
	
	private SlideDao slideDao;
	
	public void setSlideDao(SlideDao slideDao){
		this.slideDao = slideDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Slide slide) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		slide.setCreateTime(create_date);
		slideDao.save(slide);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		slideDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Slide get(Integer id){
		return slideDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Slide slide) {
		// TODO Auto-generated method stub
		slideDao.update(slide);
	}



	/* 
	 * 查询所有
	 */
	public List<Slide> findAll() {
		return  slideDao.findByHql("from Slide");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Slide user, int pageNo, int pageSize) {
		String hql = " from Slide where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		List lst = slideDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = slideDao.findByHql(hql);
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
		slideDao.bulkUpdate("delete from Slide where id in( "+ids+" )");
	}
	
	public List findSlideByTypeId(Integer id, Integer topNum) {
		return slideDao.findTopResult("from Slide where slideType='"+id+"' order by slideNum asc", topNum);
	}
	


}
