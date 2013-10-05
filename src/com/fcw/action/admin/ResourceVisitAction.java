
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.ResourceVisit;
import com.fcw.service.ResourceVisitManager;


public class ResourceVisitAction extends BaseAction {
	
	protected ResourceVisitManager mgr;
	
	public List<ResourceVisit> resourceVisitLst ;
	
	public ResourceVisit resourceVisit;
	
	public Integer id;
	
	public String ids;

	public void setResourceVisitManager(ResourceVisitManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 房产资源访客列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getResourceVisit(),pageNum, getNumPerPage());
		List<ResourceVisit> ss =(List<ResourceVisit>)page.getList();
		setResourceVisitLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除房产资源访客
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加房产资源访客
	 */
	public String add(){
		mgr.add(getResourceVisit());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑房产资源访客
	 */
	public String edit(){
		 resourceVisit = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改房产资源访客
	 */
	public String update(){
		ResourceVisit adm = mgr.get(getId());
		resourceVisit.setId(getId());
		//resourceVisit.setCreateDate(resourceVisit.getCreateDate());
		mgr.update(resourceVisit);
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


	public List<ResourceVisit> getResourceVisitLst() {
		return resourceVisitLst;
	}
	
	


	public void setResourceVisitLst(List<ResourceVisit> resourceVisitLst) {
		this.resourceVisitLst = resourceVisitLst;
	}

	public ResourceVisit getResourceVisit() {
		return resourceVisit;
	}

	public void setResourceVisit(ResourceVisit resourceVisit) {
		this.resourceVisit = resourceVisit;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
