/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogGuest;


public interface BlogGuestManager {
	
	public void add(BlogGuest blogguest);
	
	public void update(BlogGuest blogguest);
	
	public void delete(Integer id);
	
	public List<BlogGuest> findAll();
	
	public BlogGuest get(Integer id);
	
	public Page findByPage(BlogGuest blogguest,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<BlogGuest> findTopList(Integer id,Integer num);
	
	

}
