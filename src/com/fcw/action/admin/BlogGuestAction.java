
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogGuest;
import com.fcw.service.BlogGuestManager;


public class BlogGuestAction extends BaseAction {
	
	protected BlogGuestManager mgr;
	
	public List<BlogGuest> blogGuestLst ;
	
	public BlogGuest blogGuest;
	
	public Integer id;
	
	public String ids;

	public void setBlogGuestManager(BlogGuestManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 博客留言列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getBlogGuest(),pageNum, getNumPerPage());
		List<BlogGuest> ss =(List<BlogGuest>)page.getList();
		setBlogGuestLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除博客留言
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加博客留言
	 */
	public String add(){
		mgr.add(getBlogGuest());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑博客留言
	 */
	public String edit(){
		 blogGuest = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改博客留言
	 */
	public String update(){
		BlogGuest adm = mgr.get(getId());
		blogGuest.setId(getId());
		//blogGuest.setCreateDate(blogGuest.getCreateDate());
		mgr.update(blogGuest);
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


	public List<BlogGuest> getBlogGuestLst() {
		return blogGuestLst;
	}
	
	


	public void setBlogGuestLst(List<BlogGuest> blogGuestLst) {
		this.blogGuestLst = blogGuestLst;
	}

	public BlogGuest getBlogGuest() {
		return blogGuest;
	}

	public void setBlogGuest(BlogGuest blogGuest) {
		this.blogGuest = blogGuest;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
