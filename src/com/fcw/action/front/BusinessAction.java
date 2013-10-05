package com.fcw.action.front;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Admin;
import com.fcw.domain.Comment;
import com.fcw.domain.News;
import com.fcw.domain.Tender;
import com.fcw.domain.TenderGuest;
import com.fcw.domain.Users;
import com.fcw.service.SlideManager;
import com.fcw.service.TenderGuestManager;
import com.fcw.service.TenderManager;


public class BusinessAction  extends BaseFrontAction {

	protected TenderManager mgr;
	
	protected SlideManager slidemgr;
	
	protected TenderGuestManager tgmgr;

	private Page businessPage;
	
	private Page guestPage;

	private List tenderLst;
	
	private List sucessedLst;
	
	private Tender tender;
	
	private Integer id;
	
	private Integer pageNum = 1;
	private Integer numPerPage = 10;
	
	private String errMsg ;
	
	private String keywords;
	
	private List slideLst;
	

	public void setTenderManager(TenderManager mgr) {
		this.mgr = mgr;
	}	
	
	public void setSlideManager(SlideManager mgr) {
		this.slidemgr = mgr;
	}
	
	public void setTenderGuestManager(TenderGuestManager mgr) {
		this.tgmgr = mgr;
	}

	public String index() {
		slideLst = slidemgr.findSlideByTypeId(4, 5);
		Integer perNum = 10;
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		businessPage = mgr.findByPage(null, pageNum, perNum);
		tenderLst =businessPage.getList();
		sucessedLst = mgr.getNewestSucessedTender(10);
		return "index";
	}
	
	public String search() {
		try {
			keywords = URLDecoder.decode(keywords,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		slideLst = slidemgr.findSlideByTypeId(4, 5);
		Integer perNum = 10;
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		Tender td = new Tender();
		td.setName(keywords);
		businessPage = mgr.findByPage(td, pageNum, perNum);
		tenderLst =businessPage.getList();
		sucessedLst = mgr.getNewestSucessedTender(10);
		return "search";
	}
	
	public String show(){
		slideLst = slidemgr.findSlideByTypeId(4, 5);
		tender = mgr.get(id);
		sucessedLst = mgr.getNewestSucessedTender(10);
		Object obj = this.getSession().getAttribute("login");
		if(obj==null ||!"1".equals((String)obj)){
			errMsg = "招标信息仅会员可见，请 <a href=\"../user/login.jsp\"> 登录   </a> !";
			return "show";
		}
		if(obj!=null&&"1".equals((String)obj) ){
		
			if(tender.getVip()==1&&(((Users)obj).getVip()==null||((Users)obj).getVip()==0))
			errMsg = "该招标信息仅VIP会员可见！";
		}
		
		Object object =this.getSession().getAttribute("user");
		if(object!=null){
			Users  user = (Users)object;
			TenderGuest tenderGuest = new TenderGuest();
			if(user.getId()!=tender.getAuthorId()){
				tenderGuest.setUserId(user.getId());
			}
			tenderGuest.setTenderId(tender.getId());
			guestPage = tgmgr.findByPage(tenderGuest, pageNum, perNum);
		}
		return "show";
	}
	
	
	public void comment(){
		
		TenderGuest cmt = new TenderGuest();
		String id = this.getParameter("id");
		String content = this.getParameter("content");
		
		Object  obj = this.getSession().getAttribute("user");
		if(obj ==null){
			responseString("0");
			return ;
		}
		Users user = (Users)obj;
		cmt.setUserId(user.getId());
		cmt.setUserName(user.getNick());
		cmt.setEmail(user.getEmail());
		cmt.setContent(content);
		
		Tender tfr =  mgr.get(Integer.valueOf(id));
		cmt.setTenderId(tfr.getId());
		cmt.setTenderName(tfr.getName());
		
		tgmgr.add(cmt);
		responseString("1");
		
	}
	
	
	
	

	public Page getGuestPage() {
		return guestPage;
	}

	public void setGuestPage(Page guestPage) {
		this.guestPage = guestPage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	
	
	public List getSlideLst() {
		return slideLst;
	}

	public void setSlideLst(List slideLst) {
		this.slideLst = slideLst;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Page getBusinessPage() {
		return businessPage;
	}

	public void setBusinessPage(Page businessPage) {
		this.businessPage = businessPage;
	}

	public List getTenderLst() {
		return tenderLst;
	}


	public void setTenderLst(List tenderLst) {
		this.tenderLst = tenderLst;
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}

	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public Integer getNumPerPage() {
		return numPerPage;
	}



	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public List getSucessedLst() {
		return sucessedLst;
	}

	public void setSucessedLst(List sucessedLst) {
		this.sucessedLst = sucessedLst;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	

}

	

	


