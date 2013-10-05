/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.ResourceVisit;


public interface ResourceVisitManager {
	
	public void add(ResourceVisit resourcevisit);
	
	public void update(ResourceVisit resourcevisit);
	
	public void delete(Integer id);
	
	public List<ResourceVisit> findAll();
	
	public ResourceVisit get(Integer id);
	
	public Page findByPage(ResourceVisit resourcevisit,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
