/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.CommentDao;
import com.fcw.domain.Comment;
import com.fcw.service.CommentManager;


public class CommentManagerImpl implements CommentManager {
	
	
	private CommentDao commentDao;
	
	public void setCommentDao(CommentDao commentDao){
		this.commentDao = commentDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Comment comment) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		comment.setPbTime(create_date);
		commentDao.save(comment);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		commentDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Comment get(Integer id){
		return commentDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.update(comment);
	}



	/* 
	 * 查询所有
	 */
	public List<Comment> findAll() {
		return  commentDao.findByHql("from Comment");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Comment user, int pageNo, int pageSize) {
		String hql = " from Comment where 1=1 ";
		if (user != null) {
			if (user.getSourceId()!=null&&user.getSourceId()!=0) {
				hql += " and sourceId = " + user.getSourceId() ;
			}
			if (user.getTypeId()!=null&&user.getTypeId()!=0) {
				hql += " and typeId = " + user.getTypeId() ;
			}
		}
		hql += " order by id desc";
		List lst = commentDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = commentDao.findByHql(hql);
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
		commentDao.bulkUpdate("delete from Comment where id in( "+ids+" )");
	}

}
