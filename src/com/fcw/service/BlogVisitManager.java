/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogVisit;
import com.fcw.domain.Record;


public interface BlogVisitManager {
	
	public void add(BlogVisit blogvisit);
	
	public void update(BlogVisit blogvisit);
	
	public void delete(Integer id);
	
	public List<BlogVisit> findAll();
	
	public BlogVisit get(Integer id);
	
	public Page findByPage(BlogVisit blogvisit,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<BlogVisit> findTopList(Integer id,Integer num);
	
	

}
