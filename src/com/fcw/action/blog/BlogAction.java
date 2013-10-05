package com.fcw.action.blog;

import java.util.List;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.BlogVisit;
import com.fcw.domain.Users;
import com.fcw.service.ArticleManager;
import com.fcw.service.BlogGuestManager;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.BlogVisitManager;
import com.fcw.service.FriendManager;
import com.fcw.service.RecordManager;

public class BlogAction extends BaseFrontAction   {
	
	protected BlogInfoManager bmgr;
	
	protected FriendManager fmgr;
	
	protected RecordManager rmgr;
	
	protected BlogGuestManager gmgr;
	
	protected ArticleManager amgr;
	
	protected BlogVisitManager vmgr;
	
	
	private BlogInfo blogInfo;
	
	private List recordLst;
	
	private List artLst;
	
	private List guestLst;
	
	private List friendLst;
	
	private List visitLst;
	
	private Integer id;
	
	
	
	
	
	public void setArticleManager(ArticleManager mgr) {
		this.amgr = mgr;
	}
	
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	public void setFriendManager(FriendManager mgr) {
		this.fmgr = mgr;
	}
	
	public void setRecordManager(RecordManager mgr) {
		this.rmgr = mgr;
	}
	
	public void setBlogGuestManager(BlogGuestManager mgr) {
		this.gmgr = mgr;
	}
	
	public void setBlogVisitManager(BlogVisitManager mgr) {
		this.vmgr = mgr;
	}
	
	public String index(){
		
		blogInfo = bmgr.get(id);
		
		recordLst = rmgr.findTopList(id, 10);
		
		artLst = amgr.findTopList(id, 10);
		
		guestLst = gmgr.findTopList(id, 10);
		
		friendLst = fmgr.findTopList(id, 6);
		
		visitLst = vmgr.findTopList(id, 6);
		
		blogInfo.setView_count(blogInfo.getView_count()+1);
		
		bmgr.update(blogInfo);//更新访问次数
		
		Object obj =  getSession().getAttribute("user");
		if(obj!=null){
			Users usr = (Users)obj;
			if(usr.getBlog()!=null&&usr.getBlog()!=0&&usr.getBlog()!=id){
				BlogVisit visit = new BlogVisit();//更新访问用户列表
				visit.setBlogId(blogInfo.getId());
				visit.setBlogName(blogInfo.getUserName());
				visit.setVisitId(usr.getBlog());
				visit.setVisitName(usr.getBlogInfo().getUserName());
				visit.setVisitPhoto(usr.getBlogInfo().getPhoto());
				vmgr.add(visit);
			}
			
		}
		
		
		return "index";
	}
	
	


	public BlogInfo getBlogInfo() {
		return blogInfo;
	}


	public void setBlogInfo(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}


	public List getRecordLst() {
		return recordLst;
	}


	public void setRecordLst(List recordLst) {
		this.recordLst = recordLst;
	}


	public List getArtLst() {
		return artLst;
	}


	public void setArtLst(List artLst) {
		this.artLst = artLst;
	}


	public List getGuestLst() {
		return guestLst;
	}


	public void setGuestLst(List guestLst) {
		this.guestLst = guestLst;
	}


	public List getFriendLst() {
		return friendLst;
	}


	public void setFriendLst(List friendLst) {
		this.friendLst = friendLst;
	}


	public List getVisitLst() {
		return visitLst;
	}


	public void setVisitLst(List visitLst) {
		this.visitLst = visitLst;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
