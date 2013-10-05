
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Message;
import com.fcw.service.MessageManager;


public class MessageAction extends BaseAction {
	
	protected MessageManager mgr;
	
	public List<Message> messageLst ;
	
	public Message message;
	
	public Integer id;
	
	public String ids;

	public void setMessageManager(MessageManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 站内信列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getMessage(),pageNum, getNumPerPage());
		List<Message> ss =(List<Message>)page.getList();
		setMessageLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除站内信
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加站内信
	 */
	public String add(){
		mgr.add(getMessage());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑站内信
	 */
	public String edit(){
		 message = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改站内信
	 */
	public String update(){
		Message adm = mgr.get(getId());
		message.setId(getId());
		//message.setCreateDate(message.getCreateDate());
		mgr.update(message);
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


	public List<Message> getMessageLst() {
		return messageLst;
	}
	
	


	public void setMessageLst(List<Message> messageLst) {
		this.messageLst = messageLst;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
