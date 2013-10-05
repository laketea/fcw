/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Friend;
import com.fcw.domain.Record;


public interface FriendManager {
	
	public void add(Friend friend);
	
	public void update(Friend friend);
	
	public void delete(Integer id);
	
	public List<Friend> findAll();
	
	public Friend get(Integer id);
	
	public Page findByPage(Friend friend,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<Friend> findTopList(Integer id,Integer num);
		

}
