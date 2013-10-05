/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Slide;


public interface SlideManager {
	
	public void add(Slide slide);
	
	public void update(Slide slide);
	
	public void delete(Integer id);
	
	public List<Slide> findAll();
	
	public Slide get(Integer id);
	
	public Page findByPage(Slide slide,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List findSlideByTypeId(Integer id, Integer topNum);
	
	

}
