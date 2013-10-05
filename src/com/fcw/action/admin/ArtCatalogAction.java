
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.ArtCatalog;
import com.fcw.service.ArtCatalogManager;


public class ArtCatalogAction extends BaseAction {
	
	protected ArtCatalogManager mgr;
	
	public List<ArtCatalog> artCatalogLst ;
	
	public ArtCatalog artCatalog;
	
	public Integer id;
	
	public String ids;

	public void setArtCatalogManager(ArtCatalogManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 文章分类列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getArtCatalog(),pageNum, getNumPerPage());
		List<ArtCatalog> ss =(List<ArtCatalog>)page.getList();
		setArtCatalogLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除文章分类
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加文章分类
	 */
	public String add(){
		mgr.add(getArtCatalog());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑文章分类
	 */
	public String edit(){
		 artCatalog = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改文章分类
	 */
	public String update(){
		ArtCatalog adm = mgr.get(getId());
		artCatalog.setId(getId());
		//artCatalog.setCreateDate(artCatalog.getCreateDate());
		mgr.update(artCatalog);
		return ajaxForwardSuccess("修改成功!");
	}
	
	/*
	 * 批量删除
	 */
	public String batch(){
		 mgr.batchDelete(ids);	
		return ajaxForwardSuccess("操作成功!");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public List<ArtCatalog> getArtCatalogLst() {
		return artCatalogLst;
	}
	
	


	public void setArtCatalogLst(List<ArtCatalog> artCatalogLst) {
		this.artCatalogLst = artCatalogLst;
	}

	public ArtCatalog getArtCatalog() {
		return artCatalog;
	}

	public void setArtCatalog(ArtCatalog artCatalog) {
		this.artCatalog = artCatalog;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
