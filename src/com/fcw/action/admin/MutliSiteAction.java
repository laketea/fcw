
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.MutliSite;
import com.fcw.service.MutliSiteManager;


public class MutliSiteAction extends BaseAction {
	
	protected MutliSiteManager mgr;
	
	public List<MutliSite> mutliSiteLst ;
	
	public MutliSite mutliSite;
	
	public Integer id;
	
	public String ids;

	public void setMutliSiteManager(MutliSiteManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 站点信息列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getMutliSite(),pageNum, getNumPerPage());
		List<MutliSite> ss =(List<MutliSite>)page.getList();
		setMutliSiteLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除站点信息
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加站点信息
	 */
	public String add(){
		mgr.add(getMutliSite());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑站点信息
	 */
	public String edit(){
		 mutliSite = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改站点信息
	 */
	public String update(){
		MutliSite adm = mgr.get(getId());
		mutliSite.setId(getId());
		//mutliSite.setCreateDate(mutliSite.getCreateDate());
		mgr.update(mutliSite);
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


	public List<MutliSite> getMutliSiteLst() {
		return mutliSiteLst;
	}
	
	


	public void setMutliSiteLst(List<MutliSite> mutliSiteLst) {
		this.mutliSiteLst = mutliSiteLst;
	}

	public MutliSite getMutliSite() {
		return mutliSite;
	}

	public void setMutliSite(MutliSite mutliSite) {
		this.mutliSite = mutliSite;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
