/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.BlogGuestDao;
import com.fcw.domain.BlogGuest;
import com.fcw.domain.Record;
import com.fcw.service.BlogGuestManager;


public class BlogGuestManagerImpl implements BlogGuestManager {
	
	
	private BlogGuestDao blogguestDao;
	
	public void setBlogGuestDao(BlogGuestDao blogguestDao){
		this.blogguestDao = blogguestDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(BlogGuest blogguest) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		blogguest.setGuestTime(create_date);
		blogguestDao.save(blogguest);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		blogguestDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public BlogGuest get(Integer id){
		return blogguestDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(BlogGuest blogguest) {
		// TODO Auto-generated method stub
		blogguestDao.update(blogguest);
	}


	public List<BlogGuest> findTopList(Integer id,Integer num){
		return blogguestDao.findTopResult("from BlogGuest where blogId = "+id+" order by id desc", num);
	}

	/* 
	 * 查询所有
	 */
	public List<BlogGuest> findAll() {
		return  blogguestDao.findByHql("from BlogGuest");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(BlogGuest user, int pageNo, int pageSize) {
		String hql = " from BlogGuest where 1=1 ";
		if (user != null) {
			
			if (user.getBlogId()!=null&&user.getBlogId()!=0) {
				hql += " and blogId = " + user.getBlogId();
			}
		}
		
		hql += " order by id desc";
		List lst = blogguestDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = blogguestDao.findByHql(hql);
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
		blogguestDao.bulkUpdate("delete from BlogGuest where id in( "+ids+" )");
	}

}
