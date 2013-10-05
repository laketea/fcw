/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Resource;


public interface ResourceManager {
	
	public void add(Resource resource);
	
	public void update(Resource resource);
	
	public void delete(Integer id);
	
	public List<Resource> findAll();
	
	public Resource get(Integer id);
	
	public Page findByPage(Resource resource,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List findChannelIndexRecommentTopLst(Integer channelId,Integer num);
	
	public List findIndexRecommentTopLst(Integer num);
	
	public List<Resource> findDfAll();
	
	

}
