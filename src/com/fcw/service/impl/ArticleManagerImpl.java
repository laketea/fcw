/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.ArticleDao;
import com.fcw.domain.Article;
import com.fcw.domain.Record;
import com.fcw.service.ArticleManager;


public class ArticleManagerImpl implements ArticleManager {
	
	
	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao){
		this.articleDao = articleDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Article article) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		article.setPhTime(create_date);
		articleDao.save(article);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		articleDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Article get(Integer id){
		return articleDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}
	
	public List<Article> findTopList(Integer id,Integer num){
		return articleDao.findTopResult("from Article where blogId = "+id+" order by id desc", num);
	}



	/* 
	 * 查询所有
	 */
	public List<Article> findAll() {
		return  articleDao.findByHql("from Article");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Article user, int pageNo, int pageSize) {
		String hql = " from Article where 1=1 ";
		if (user != null) {
			if (user.getCatalogId()!=null&&user.getCatalogId()!=0) {
				hql += " and catalogId = " + user.getCatalogId();
			}
			if (user.getBlogId()!=null&&user.getBlogId()!=0) {
				hql += " and blogId = " + user.getBlogId();
			}
		}
		
		hql += " order by id desc";
		List lst = articleDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = articleDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}
	
	
	public Page findFriendsArtPage(Integer id, int pageNo, int pageSize) {
		String hql = "select rd from Article as rd, Friend as fr where ( rd.blogId = fr.fromId and fr.toId = "+id+" ) or " +
				"(  rd.blogId = fr.toId and fr.fromId = "+id+" )";
		hql += " order by rd.id desc";
		List lst = articleDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = articleDao.findByHql(hql);
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
		articleDao.bulkUpdate("delete from Article where id in( "+ids+" )");
	}

}
