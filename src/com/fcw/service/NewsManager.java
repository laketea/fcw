/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.News;


public interface NewsManager {
	
	public void add(News news);
	
	public void update(News news);
	
	public void delete(Integer id);
	
	public List<News> findAll();
	
	public News get(Integer id);
	
	public Page findByPage(News news,int pageNo ,int PageSize);
	
	public List findTopNewsByChannelId(Integer id,Integer topNum);
	
	public List findTopNewsByChannelId2(Integer id,Integer topNum);
	
	public List findTopNews(Integer topNum);
	
	//首页头条
	public List findDftTopNews(Integer topNum,Integer id);
	
	//首页头条2
	public List findDftTop2News(Integer topNum,Integer id);
		
	//首页推荐
	public List findDftNews(Integer topNum,Integer id);
	
	
	public List findPhotoNews(Integer topNum,Integer id);
	
	public void batchDelete(String ids);
	
	public List findHotNews(Integer topNum,Integer id);
	
	
	
	
	

}
