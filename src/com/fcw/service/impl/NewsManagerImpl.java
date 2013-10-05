/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.auto.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.NewsDao;
import com.fcw.domain.News;
import com.fcw.service.NewsManager;


public class NewsManagerImpl implements NewsManager {
	
	
	private NewsDao newsDao;
	
	public void setNewsDao(NewsDao newsDao){
		this.newsDao = newsDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(News news) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		news.setPbTime(create_date);
		newsDao.save(news);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		newsDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public News get(Integer id){
		return newsDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(News news) {
		// TODO Auto-generated method stub
		newsDao.update(news);
	}



	/* 
	 * 查询所有
	 */
	public List<News> findAll() {
		return  newsDao.findByHql("from News");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(News user, int pageNo, int pageSize) {
		String hql = " from News where 1=1 ";
		if (user != null) {
			if (Utils.notNull(user.getTitle())) {
				hql += " and ( title like '%" + user.getTitle() + "%' or description like '%"+ user.getTitle()+"%' ) ";
			}
			if (user.getChannelId()!=null) {
				hql += " and channelId = " + user.getChannelId() + "";
			}
			if(user.getCond()==1){//头条推荐
				hql += " and topStatus = 1";
			}
			if(user.getCond()==2){//头条推荐2
				hql += " and topsStatus = 1";
			}
			if(user.getCond()==3){//首页推荐
				hql += " and dftStatus = 1";
			}
			if(user.getHasPhoto()!=null){//首页推荐
				hql += " and hasPhoto = 1";
			}
		}
		
		hql += " order by id desc";
		List lst = newsDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = newsDao.findByHql(hql);
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
		newsDao.bulkUpdate("delete from News where id in( "+ids+" )");
	}

	public List findTopNewsByChannelId(Integer id, Integer topNum) {
		return newsDao.findTopResult("from News where channelId="+id+" order by id desc", topNum);
	}
	
	public List findTopNewsByChannelId2(Integer id, Integer topNum) {
		return newsDao.findTopResult("from News where channelId="+id+" and zxTopStatus = 1 order by zxTopNum, id desc", topNum);
	}
	
	public List findTopNews(Integer topNum) {
		return newsDao.findTopResult("from News  order by id desc", topNum);
	}
	
	public List findDftTopNews(Integer topNum,Integer id) {
		return newsDao.findTopResult("from News where topStatus=1 "+(id==0?"":(" and channelId="+id))+"  order by topStatus asc", topNum);
	}
	
	public List findDftTop2News(Integer topNum,Integer id) {
		return newsDao.findTopResult("from News where topsStatus=1 "+(id==0?"":(" and channelId="+id))+"  order by topsNum asc", topNum);
	}
	
	public List findDftNews(Integer topNum,Integer id) {
		return newsDao.findTopResult("from News where dftStatus=1 "+ (id==0?"":(" and channelId="+id)) +"  order by dftStatus asc", topNum);
	}
	
	public List findPhotoNews(Integer topNum,Integer id) {
		return newsDao.findTopResult("from News where hasPhoto=1 "+ (id==0?"":(" and channelId="+id)) +"  order by id desc", topNum);
	}
	
	public List findHotNews(Integer topNum,Integer id) {
		return newsDao.findTopResult("from News "+ (id==0?"":(" where channelId="+id)) +"  order by visitCount desc", topNum);
	}

}
