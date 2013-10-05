/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Information;


public interface InformationManager {
	
	public void add(Information information);
	
	public void update(Information information);
	
	public void delete(Integer id);
	
	public List<Information> findAll();
	
	public Information get(Integer id);
	
	public Page findByPage(Information information,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<Information>findHotList(Integer num);
	
	public List<Information>findRecommentList(Integer num);
	
	public List<Information>findRecentList(Integer num);
	
	public List<Information> findPdRecmdList(Integer num);
	
	public List findTopRecommendList(Integer num);
	
	public List<Information> findZlRecmdList(Integer num,Integer vip) ;
	

}
