/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.BlogInfoDao;
import com.fcw.domain.BlogInfo;
import com.fcw.service.BlogInfoManager;


public class BlogInfoManagerImpl implements BlogInfoManager {
	
	
	private BlogInfoDao bloginfoDao;
	
	public void setBlogInfoDao(BlogInfoDao bloginfoDao){
		this.bloginfoDao = bloginfoDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(BlogInfo bloginfo) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		bloginfo.setCreateTime(create_date);
		bloginfoDao.save(bloginfo);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		bloginfoDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public BlogInfo get(Integer id){
		return bloginfoDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(BlogInfo bloginfo) {
		// TODO Auto-generated method stub
		bloginfoDao.update(bloginfo);
	}



	/* 
	 * 查询所有
	 */
	public List<BlogInfo> findAll() {
		return  bloginfoDao.findByHql("from BlogInfo");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(BlogInfo user, int pageNo, int pageSize) {
		String hql = " from BlogInfo where 1=1 ";
		if (user != null) {
			
			if (Utils.notNull(user.getUserName())) {
				hql += " and userName like '%" + user.getUserName() + "%'";
			}
		}
		hql += " order by id desc";
		List lst = bloginfoDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = bloginfoDao.findByHql(hql);
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
		bloginfoDao.bulkUpdate("delete from BlogInfo where id in( "+ids+" )");
	}

}
