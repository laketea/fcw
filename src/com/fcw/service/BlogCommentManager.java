/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogComment;


public interface BlogCommentManager {
	
	public void add(BlogComment blogcomment);
	
	public void update(BlogComment blogcomment);
	
	public void delete(Integer id);
	
	public List<BlogComment> findAll();
	
	public BlogComment get(Integer id);
	
	public Page findByPage(BlogComment blogcomment,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
