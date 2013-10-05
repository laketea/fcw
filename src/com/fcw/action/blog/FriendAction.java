package com.fcw.action.blog;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Friend;
import com.fcw.domain.Users;
import com.fcw.service.BlogGuestManager;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.FriendManager;

public class FriendAction extends BaseFrontAction  {
	
	protected FriendManager mgr;
	
	protected BlogInfoManager bmgr;
	
	private Page page;
	
	private Integer id;
	
	private BlogInfo blog;
	
	public void setFriendManager(FriendManager mgr) {
		this.mgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	
	
	
	public String list(){
		
		blog = bmgr.get(id);
		
		Friend friend = new Friend();
		
		fetchPageNum();
		friend.setOwn(id);
		
		page = mgr.findByPage(friend, pageNum, perNum);
		
		return "index";
	}

	
	

	public BlogInfo getBlog() {
		return blog;
	}

	public void setBlog(BlogInfo blog) {
		this.blog = blog;
	}

	public Page getPage() {
		return page;
	}

	


	public void setPage(Page page) {
		this.page = page;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
