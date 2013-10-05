
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Friend;
import com.fcw.service.FriendManager;


public class FriendAction extends BaseAction {
	
	protected FriendManager mgr;
	
	public List<Friend> friendLst ;
	
	public Friend friend;
	
	public Integer id;
	
	public String ids;

	public void setFriendManager(FriendManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 好友列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getFriend(),pageNum, getNumPerPage());
		List<Friend> ss =(List<Friend>)page.getList();
		setFriendLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除好友
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加好友
	 */
	public String add(){
		mgr.add(getFriend());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑好友
	 */
	public String edit(){
		 friend = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改好友
	 */
	public String update(){
		Friend adm = mgr.get(getId());
		friend.setId(getId());
		//friend.setCreateDate(friend.getCreateDate());
		mgr.update(friend);
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


	public List<Friend> getFriendLst() {
		return friendLst;
	}
	
	


	public void setFriendLst(List<Friend> friendLst) {
		this.friendLst = friendLst;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
