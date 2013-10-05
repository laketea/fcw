package com.fcw.action.usercenter;

import java.util.List;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.domain.DownLoad;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.News;
import com.fcw.domain.Reward;
import com.fcw.domain.Tender;
import com.fcw.domain.TenderGuest;
import com.fcw.domain.Users;
import com.fcw.listener.InforCache;
import com.fcw.service.CommentManager;
import com.fcw.service.DownLoadManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.RewardManager;
import com.fcw.service.TenderGuestManager;
import com.fcw.service.TenderManager;

public class UserTenderAction extends BaseFrontAction {

	protected TenderManager mgr;
	
	protected TenderGuestManager tgmgr;

	private Page page;

	private Integer id;

	private Tender tender;


	private InforCache cache = InforCache.getInstance();

	public void setTenderManager(TenderManager mgr) {
		this.mgr = mgr;
	}
	
	public void setTenderGuestManager(TenderGuestManager mgr) {
		this.tgmgr = mgr;
	}



	/*
	 * 用户发布的招标信息
	 */
	public String list() {

		Users user = (Users) getSession().getAttribute("user");
		Tender tender = new Tender();
		fetchPageNum();
		tender.setAuthorId(user.getId());
		page = mgr.findByPage(tender, pageNum, perNum);
		return "list";
	}

	
	
	
	public String msglist() {
		
		Users user = (Users) getSession().getAttribute("user");
		TenderGuest tenderGuest = new TenderGuest();
		fetchPageNum();
		tenderGuest.setUserId(user.getId());
		page = tgmgr.findByPage(tenderGuest, pageNum, perNum);
		
		return "msg-list";
	}
	
	public String publish(){
		Users user = (Users) getSession().getAttribute("user");
		tender.setAuthorId(user.getId());
		tender.setAuthorName(user.getNick());
		mgr.add(tender);
		return "sucessed";
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}



	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}



	

}
