
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogComment;
import com.fcw.service.BlogCommentManager;


public class BlogCommentAction extends BaseAction {
	
	protected BlogCommentManager mgr;
	
	public List<BlogComment> blogCommentLst ;
	
	public BlogComment blogComment;
	
	public Integer id;
	
	public String ids;

	public void setBlogCommentManager(BlogCommentManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 博客评论列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getBlogComment(),pageNum, getNumPerPage());
		List<BlogComment> ss =(List<BlogComment>)page.getList();
		setBlogCommentLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除博客评论
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加博客评论
	 */
	public String add(){
		mgr.add(getBlogComment());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑博客评论
	 */
	public String edit(){
		 blogComment = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改博客评论
	 */
	public String update(){
		BlogComment adm = mgr.get(getId());
		blogComment.setId(getId());
		//blogComment.setCreateDate(blogComment.getCreateDate());
		mgr.update(blogComment);
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


	public List<BlogComment> getBlogCommentLst() {
		return blogCommentLst;
	}
	
	


	public void setBlogCommentLst(List<BlogComment> blogCommentLst) {
		this.blogCommentLst = blogCommentLst;
	}

	public BlogComment getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(BlogComment blogComment) {
		this.blogComment = blogComment;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
