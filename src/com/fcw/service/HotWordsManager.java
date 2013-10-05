/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.HotWords;


public interface HotWordsManager {
	
	public void add(HotWords hotwords);
	
	public void update(HotWords hotwords);
	
	public void delete(Integer id);
	
	public List<HotWords> findAll();
	
	public HotWords get(Integer id);
	
	public Page findByPage(HotWords hotwords,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
