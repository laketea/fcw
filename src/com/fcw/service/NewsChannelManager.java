/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.NewsChannel;


public interface NewsChannelManager {
	
	public void add(NewsChannel newschannel);
	
	public void update(NewsChannel newschannel);
	
	public void delete(Integer id);
	
	public List<NewsChannel> findAll();
	
	public NewsChannel get(Integer id);
	
	public Page findByPage(NewsChannel newschannel,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<NewsChannel> getDefaultChannelLst();
	
	

}
