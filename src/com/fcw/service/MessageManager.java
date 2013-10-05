/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Message;


public interface MessageManager {
	
	public void add(Message message);
	
	public void update(Message message);
	
	public void delete(Integer id);
	
	public List<Message> findAll();
	
	public Message get(Integer id);
	
	public Page findByPage(Message message,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
