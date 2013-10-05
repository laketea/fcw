package com.fcw.action.usercenter;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.BlogVisit;
import com.fcw.domain.Friend;
import com.fcw.domain.Users;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.BlogVisitManager;
import com.fcw.service.FriendManager;

public class UserFriendAction extends BaseFrontAction {

	protected FriendManager mgr;
	
	protected BlogInfoManager bmgr;
	
	protected BlogVisitManager vmgr;

	private Page page;

	private Integer id;
	
	private String keywords;

	public void setFriendManager(FriendManager mgr) {
		this.mgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	public void setBlogVisitManager(BlogVisitManager mgr) {
		this.vmgr = mgr;
	}

	public String list() {

		Friend friend = new Friend();
		
		Users user = (Users) getSession().getAttribute("user");
		id = user.getBlogInfo().getId();

		fetchPageNum();
		friend.setToId(id);
		friend.setStatus(3);
		page = mgr.findByPage(friend, pageNum, perNum);

		return "list";
	}
	
	
	public String applylist(){
		Users user = (Users) getSession().getAttribute("user");
		id = user.getBlogInfo().getId();
		Friend friend = new Friend();
		fetchPageNum();
		friend.setToId(id);
		friend.setStatus(1);
		page = mgr.findByPage(friend, pageNum, perNum);
		
		return "applylist";
	}
	
	public String find(){
		
		BlogInfo blog = new BlogInfo();
		
		blog.setUserName(keywords);
		fetchPageNum();
		page = bmgr.findByPage(blog, pageNum, perNum);
		
		return "find";
	}
	
	public String visit(){
		
		
		Users user = (Users) getSession().getAttribute("user");
		id = user.getBlogInfo().getId();
		
		BlogVisit visit = new BlogVisit();
		visit.setBlogId(id);
		
		page = vmgr.findByPage(visit, pageNum, perNum);
		
		return "visit";
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
	
	
	

}
