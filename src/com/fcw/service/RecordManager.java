/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Record;


public interface RecordManager {
	
	public void add(Record record);
	
	public void update(Record record);
	
	public void delete(Integer id);
	
	public List<Record> findAll();
	
	public Record get(Integer id);
	
	public Page findByPage(Record record,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<Record> findTopList(Integer id,Integer num);
	
	public Page findFriendsRecordPage(Integer id, int pageNo, int pageSize);
	
//	public List<Record> findFriendsRecord()
	
	

}
