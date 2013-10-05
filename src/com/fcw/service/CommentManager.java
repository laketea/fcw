/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;


public interface CommentManager {
	
	public void add(Comment comment);
	
	public void update(Comment comment);
	
	public void delete(Integer id);
	
	public List<Comment> findAll();
	
	public Comment get(Integer id);
	
	public Page findByPage(Comment comment,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
