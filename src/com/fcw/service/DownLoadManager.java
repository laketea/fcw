/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.DownLoad;


public interface DownLoadManager {
	
	public void add(DownLoad download);
	
	public void update(DownLoad download);
	
	public void delete(Integer id);
	
	public List<DownLoad> findAll();
	
	public DownLoad get(Integer id);
	
	public Page findByPage(DownLoad download,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);

}
