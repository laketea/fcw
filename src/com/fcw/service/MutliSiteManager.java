/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.MutliSite;


public interface MutliSiteManager {
	
	public void add(MutliSite mutlisite);
	
	public void update(MutliSite mutlisite);
	
	public void delete(Integer id);
	
	public List<MutliSite> findAll();
	
	public MutliSite get(Integer id);
	
	public Page findByPage(MutliSite mutlisite,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
