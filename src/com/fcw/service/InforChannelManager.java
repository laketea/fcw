/**
 * 
 */ 
package com.fcw.service; 

import java.util.HashMap;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.domain.ResourceChannel;


public interface InforChannelManager {
	
	public void add(InforChannel inforchannel);
	
	public void update(InforChannel inforchannel);
	
	public void delete(Integer id);
	
	public List<InforChannel> findAll();
	
	public InforChannel get(Integer id);
	
	public List<InforChannel> findFirstLevelChannel();
	
	public Page findByPage(InforChannel inforchannel,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public HashMap<Integer,InforChannel> findAllMap();
	
	

}
