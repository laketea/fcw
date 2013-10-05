
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogVisit;
import com.fcw.service.BlogVisitManager;


public class BlogVisitAction extends BaseAction {
	
	protected BlogVisitManager mgr;
	
	public List<BlogVisit> blogVisitLst ;
	
	public BlogVisit blogVisit;
	
	public Integer id;
	
	public String ids;

	public void setBlogVisitManager(BlogVisitManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 博客访问信息列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getBlogVisit(),pageNum, getNumPerPage());
		List<BlogVisit> ss =(List<BlogVisit>)page.getList();
		setBlogVisitLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除博客访问信息
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加博客访问信息
	 */
	public String add(){
		mgr.add(getBlogVisit());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑博客访问信息
	 */
	public String edit(){
		 blogVisit = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改博客访问信息
	 */
	public String update(){
		BlogVisit adm = mgr.get(getId());
		blogVisit.setId(getId());
		//blogVisit.setCreateDate(blogVisit.getCreateDate());
		mgr.update(blogVisit);
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


	public List<BlogVisit> getBlogVisitLst() {
		return blogVisitLst;
	}
	
	


	public void setBlogVisitLst(List<BlogVisit> blogVisitLst) {
		this.blogVisitLst = blogVisitLst;
	}

	public BlogVisit getBlogVisit() {
		return blogVisit;
	}

	public void setBlogVisit(BlogVisit blogVisit) {
		this.blogVisit = blogVisit;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
