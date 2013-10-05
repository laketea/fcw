/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.BlogVisitDao;
import com.fcw.domain.BlogVisit;
import com.fcw.domain.Record;
import com.fcw.service.BlogVisitManager;


public class BlogVisitManagerImpl implements BlogVisitManager {
	
	
	private BlogVisitDao blogvisitDao;
	
	public void setBlogVisitDao(BlogVisitDao blogvisitDao){
		this.blogvisitDao = blogvisitDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(BlogVisit blogvisit) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		blogvisit.setVisiteTime(create_date);
		blogvisitDao.save(blogvisit);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		blogvisitDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public BlogVisit get(Integer id){
		return blogvisitDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(BlogVisit blogvisit) {
		// TODO Auto-generated method stub
		blogvisitDao.update(blogvisit);
	}
	
	public List<BlogVisit> findTopList(Integer id,Integer num){
		return blogvisitDao.findTopResult("from BlogVisit where blogId = "+id+" order by id desc", num);
	}



	/* 
	 * 查询所有
	 */
	public List<BlogVisit> findAll() {
		return  blogvisitDao.findByHql("from BlogVisit");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(BlogVisit user, int pageNo, int pageSize) {
		String hql = " from BlogVisit where 1=1 ";
		if (user != null) {
			if (user.getBlogId()!=null&&user.getBlogId()!=0) {
				hql += " and blogId = " + user.getBlogId();
			}
		}
		hql += " order by id desc";
		List lst = blogvisitDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = blogvisitDao.findByHql(hql);
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
		blogvisitDao.bulkUpdate("delete from BlogVisit where id in( "+ids+" )");
	}

}
