/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Adv;


public interface AdvManager {
	
	public void add(Adv adv);
	
	public void update(Adv adv);
	
	public void delete(Integer id);
	
	public List<Adv> findAll();
	
	public Adv get(Integer id);
	
	public Page findByPage(Adv adv,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List findAdvByType(Integer id);
	
	

}
