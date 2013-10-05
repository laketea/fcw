package com.fcw.action.blog;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogGuest;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Information;
import com.fcw.domain.Users;
import com.fcw.service.BlogGuestManager;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.InformationManager;
import com.fcw.service.ResourceManager;

public class GuestAction extends BaseFrontAction {
	
	public static String DFT_PHOTO ="../resource/img/testtest.jpg";
	
	protected BlogGuestManager mgr;
	
	protected BlogInfoManager bmgr;
	
	private BlogGuest guest ;
	
	private Page page;
	
	private Integer id; 
	
	private BlogInfo blog;
	
	public void setBlogGuestManager(BlogGuestManager mgr) {
		this.mgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	public String list(){
			
		blog = bmgr.get(id);
		guest = new BlogGuest();
		fetchPageNum();
		guest.setBlogId(id);
		page = mgr.findByPage(guest, pageNum, perNum);
		
		return "list";
	}
	
	public void message(){
		
		Object obj =  getSession().getAttribute("user");
		if(obj==null){
			this.responseString("1");
			return ;
		}
		Users user = (Users)obj;
		
		if(user.getBlog()==null||user.getBlog()==0){
			this.responseString("2");
			return ;
		}
		
		
		BlogInfo blog = user.getBlogInfo();
		String content = this.getParameter("content");
		BlogGuest guest = new BlogGuest();
		guest.setContent(content);
		guest.setBlogId(Integer.valueOf(getParameter("id")));
		guest.setGuestId(user.getBlogInfo().getId());
		guest.setGuestName(blog.getUserName());
		guest.setGuestPhoto(DFT_PHOTO);
		
		mgr.add(guest);
		this.responseString("3");
		return ;
	}

	
	
	
	public BlogInfo getBlog() {
		return blog;
	}

	public void setBlog(BlogInfo blog) {
		this.blog = blog;
	}

	public BlogGuest getGuest() {
		return guest;
	}

	public void setGuest(BlogGuest guest) {
		this.guest = guest;
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
