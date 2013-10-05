/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.ArtCatalog;


public interface ArtCatalogManager {
	
	public void add(ArtCatalog artcatalog);
	
	public void update(ArtCatalog artcatalog);
	
	public void delete(Integer id);
	
	public List<ArtCatalog> findAll();
	
	public List<ArtCatalog> findByBlog(Integer id);
	
	public ArtCatalog get(Integer id);
	
	public Page findByPage(ArtCatalog artcatalog,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
