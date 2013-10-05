
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.service.CommentManager;


public class CommentAction extends BaseAction {
	
	protected CommentManager mgr;
	
	public List<Comment> commentLst ;
	
	public Comment comment;
	
	public Integer id;
	
	public String ids;

	public void setCommentManager(CommentManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 评论列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getComment(),pageNum, getNumPerPage());
		List<Comment> ss =(List<Comment>)page.getList();
		setCommentLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除评论
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加评论
	 */
	public String add(){
		mgr.add(getComment());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑评论
	 */
	public String edit(){
		 comment = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改评论
	 */
	public String update(){
		Comment adm = mgr.get(getId());
		comment.setId(getId());
		//comment.setCreateDate(comment.getCreateDate());
		mgr.update(comment);
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


	public List<Comment> getCommentLst() {
		return commentLst;
	}
	
	


	public void setCommentLst(List<Comment> commentLst) {
		this.commentLst = commentLst;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
