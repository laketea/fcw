/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Article;
import com.fcw.domain.Record;


public interface ArticleManager {
	
	public void add(Article article);
	
	public void update(Article article);
	
	public void delete(Integer id);
	
	public List<Article> findAll();
	
	public Article get(Integer id);
	
	public Page findByPage(Article article,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List<Article> findTopList(Integer id,Integer num);
	
	public Page findFriendsArtPage(Integer id, int pageNo, int pageSize);

}
