
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;
import com.fcw.service.BlogInfoManager;


public class BlogInfoAction extends BaseAction {
	
	protected BlogInfoManager mgr;
	
	public List<BlogInfo> blogInfoLst ;
	
	public BlogInfo blogInfo;
	
	public Integer id;
	
	public String ids;

	public void setBlogInfoManager(BlogInfoManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 博客信息列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getBlogInfo(),pageNum, getNumPerPage());
		List<BlogInfo> ss =(List<BlogInfo>)page.getList();
		setBlogInfoLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除博客信息
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加博客信息
	 */
	public String add(){
		mgr.add(getBlogInfo());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑博客信息
	 */
	public String edit(){
		 blogInfo = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改博客信息
	 */
	public String update(){
		BlogInfo adm = mgr.get(getId());
		blogInfo.setId(getId());
		//blogInfo.setCreateDate(blogInfo.getCreateDate());
		mgr.update(blogInfo);
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


	public List<BlogInfo> getBlogInfoLst() {
		return blogInfoLst;
	}
	
	


	public void setBlogInfoLst(List<BlogInfo> blogInfoLst) {
		this.blogInfoLst = blogInfoLst;
	}

	public BlogInfo getBlogInfo() {
		return blogInfo;
	}

	public void setBlogInfo(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
