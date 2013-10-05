/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.BlogCommentDao;
import com.fcw.domain.BlogComment;
import com.fcw.service.BlogCommentManager;


public class BlogCommentManagerImpl implements BlogCommentManager {
	
	
	private BlogCommentDao blogcommentDao;
	
	public void setBlogCommentDao(BlogCommentDao blogcommentDao){
		this.blogcommentDao = blogcommentDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(BlogComment blogcomment) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		blogcomment.setCmtTime(create_date);
		blogcommentDao.save(blogcomment);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		blogcommentDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public BlogComment get(Integer id){
		return blogcommentDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		blogcommentDao.update(blogcomment);
	}



	/* 
	 * 查询所有
	 */
	public List<BlogComment> findAll() {
		return  blogcommentDao.findByHql("from BlogComment");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(BlogComment user, int pageNo, int pageSize) {
		String hql = " from BlogComment where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		
		hql += " order by id desc";
		List lst = blogcommentDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = blogcommentDao.findByHql(hql);
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
		blogcommentDao.bulkUpdate("delete from BlogComment where id in( "+ids+" )");
	}

}
