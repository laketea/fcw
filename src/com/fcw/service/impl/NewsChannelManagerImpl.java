/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.NewsChannelDao;
import com.fcw.dao.NewsDao;
import com.fcw.domain.NewsChannel;
import com.fcw.service.NewsChannelManager;


public class NewsChannelManagerImpl implements NewsChannelManager {
	
	private final static Integer TOP_CHANNEL_NEWS_NUM =8;
	private final static Integer LAST_NEWS_NUM =20;
	
	
	private NewsChannelDao newschannelDao;
	
	private NewsDao newsDao;
	
	public void setNewsChannelDao(NewsChannelDao newschannelDao){
		this.newschannelDao = newschannelDao;
	}
	
	public void setNewsDao(NewsDao newsDao){
		this.newsDao = newsDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(NewsChannel newschannel) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		newschannel.setCreate_time(create_date);
		newschannelDao.save(newschannel);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		newschannelDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public NewsChannel get(Integer id){
		return newschannelDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(NewsChannel newschannel) {
		// TODO Auto-generated method stub
		newschannelDao.update(newschannel);
	}



	/* 
	 * 查询所有
	 */
	public List<NewsChannel> findAll() {
		return  newschannelDao.findByHql("from NewsChannel");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(NewsChannel user, int pageNo, int pageSize) {
		String hql = " from NewsChannel where 1=1 ";
		
		List lst = newschannelDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = newschannelDao.findByHql(hql);
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
		newschannelDao.bulkUpdate("delete from NewsChannel where id in( "+ids+" )");
	}
	
	public List<NewsChannel> getDefaultChannelLst(){
		List<NewsChannel> lst = this.findAll();
		if(Utils.listNull(lst)){
			return null;
		}
		for(NewsChannel channel:lst){
			channel.setNewsLst(Utils.listInit(newsDao.findTopResultByChannelId(channel.getId(), TOP_CHANNEL_NEWS_NUM)));
		}
		return lst;
	}

}
