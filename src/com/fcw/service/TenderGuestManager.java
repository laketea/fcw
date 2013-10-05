/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.TenderGuest;


public interface TenderGuestManager {
	
	public void add(TenderGuest tenderguest);
	
	public void update(TenderGuest tenderguest);
	
	public void delete(Integer id);
	
	public List<TenderGuest> findAll();
	
	public TenderGuest get(Integer id);
	
	public Page findByPage(TenderGuest tenderguest,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
