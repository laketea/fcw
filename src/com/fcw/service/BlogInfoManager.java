/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;


public interface BlogInfoManager {
	
	public void add(BlogInfo bloginfo);
	
	public void update(BlogInfo bloginfo);
	
	public void delete(Integer id);
	
	public List<BlogInfo> findAll();
	
	public BlogInfo get(Integer id);
	
	public Page findByPage(BlogInfo bloginfo,int pageNo ,int PageSize);
	
	
	
	public void batchDelete(String ids);
	
	

}
