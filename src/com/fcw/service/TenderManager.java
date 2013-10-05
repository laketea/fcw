/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Tender;


public interface TenderManager {
	
	public void add(Tender tender);
	
	public void update(Tender tender);
	
	public void delete(Integer id);
	
	public List<Tender> findAll();
	
	public Tender get(Integer id);
	
	public Page findByPage(Tender tender,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List getNewestSucessedTender(Integer num);
	
	public List getDfRecommendList(Integer num);
	
	public List getNewestList(Integer num);
	
	public List getHotList(Integer num);
}
