/**
 * 
 */ 
package com.fcw.service; 

import java.util.HashMap;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.ResourceChannel;


public interface ResourceChannelManager {
	
	public void add(ResourceChannel resourcechannel);
	
	public void update(ResourceChannel resourcechannel);
	
	public void delete(Integer id);
	
	public List<ResourceChannel> findAll();
	
	public List<ResourceChannel> findAllDfstatus(Integer id);
	
	public ResourceChannel get(Integer id);
	
	public Page findByPage(ResourceChannel resourcechannel,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<ResourceChannel> findFirstLevelChannel();
	
	public HashMap<Integer,ResourceChannel> findAllMap();
	
	

}
